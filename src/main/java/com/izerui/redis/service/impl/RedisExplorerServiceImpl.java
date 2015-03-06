package com.izerui.redis.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.izerui.redis.command.JedisExecutor;
import com.izerui.redis.command.hash.AddHash;
import com.izerui.redis.command.hash.ReadHash;
import com.izerui.redis.command.key.*;
import com.izerui.redis.command.list.AllList;
import com.izerui.redis.command.list.SetValue;
import com.izerui.redis.command.list.UpdateList;
import com.izerui.redis.command.server.DbAmount;
import com.izerui.redis.command.set.AddSet;
import com.izerui.redis.command.set.AllSet;
import com.izerui.redis.command.set.UpdateSet;
import com.izerui.redis.command.string.ReadString;
import com.izerui.redis.command.string.UpdateString;
import com.izerui.redis.command.zset.AllZSet;
import com.izerui.redis.command.zset.UpdateZSet;
import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;
import com.izerui.redis.repository.ServerConfigRepository;
import com.izerui.redis.service.RedisExplorerService;
import com.izerui.redis.utils.MapListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Tuple;

import java.util.*;

/**
 * Created by serv on 2015/2/3.
 */
@Service
@Transactional
@RemotingDestination
public class RedisExplorerServiceImpl  implements RedisExplorerService {

    @Autowired
    ServerConfigRepository serverConfigRepository;

    @Override
    public List<RedisServerConfig> getServerConfigs() {
        return serverConfigRepository.findAll(new Sort(new Sort.Order("createTime")));

    }

    @Override
    public RedisServerConfig saveServerConfig(RedisServerConfig redisServerConfig) {
        if(redisServerConfig.getId()==null){
            redisServerConfig.setId(UUID.randomUUID().toString());
        }
        return serverConfigRepository.save(redisServerConfig);
    }

    @Override
    public void removeServerConfig(RedisServerConfig redisServerConfig) {
        serverConfigRepository.delete(redisServerConfig);
    }

    @Override
    public int getDbAmount(RedisServerConfig redisServerConfig) {
        return new JedisExecutor(redisServerConfig).execute(new DbAmount()).getDbAmount();
    }

    @Override
    public List<Key> getKeys(RedisServerConfig redisServerConfig) {
        return new JedisExecutor(redisServerConfig).execute(new ListKeys()).getKeys();
    }

    @Override
    public Key getKey(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new KeyInfo(key)).getKey();
    }

    @Override
    public String getStringValue(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new ReadString(key)).getValue();
    }

    @Override
    public void saveStringValue(RedisServerConfig redisServerConfig, String key, String value) {
        new JedisExecutor(redisServerConfig).execute(new UpdateString(key,value));
    }

    @Override
    public List<Map> getHashValue(RedisServerConfig redisServerConfig, String key) {
        Map map = new JedisExecutor(redisServerConfig).execute(new ReadHash(key)).getValue();
        return MapListUtils.map2KvLists(map,"key","value");
    }

    @Override
    public void saveHashValue(RedisServerConfig redisServerConfig, String key, List<Map> mapList) {
        JedisExecutor executor = new JedisExecutor(redisServerConfig);
        //delete key
        executor.execute(new Delete(key));
        //add hash
        executor.execute(new AddHash(key,MapListUtils.kvList2Map(mapList,"key","value")));
    }

    @Override
    public List<Map> getListValue(RedisServerConfig redisServerConfig, String key) {
        List<String> values = new JedisExecutor(redisServerConfig).execute(new AllList(key)).getValues();
        return Lists.transform(values, new Function<String, Map>() {
            @Override
            public Map apply(String s) {
                Map<String,String> map = new HashMap();
                map.put("label",s);
                return map;
            }
        });
    }

    @Override
    public void setListValue(RedisServerConfig redisServerConfig, String key, List<Map> values) {
        List<String> newValues = Lists.transform(values, new Function<Map, String>() {
            @Override
            public String apply(Map stringStringMap) {
                return String.valueOf(stringStringMap.get("label"));
            }
        });
        new JedisExecutor(redisServerConfig).execute(new UpdateList(key, newValues));
    }

    @Override
    public Set<Map> getSetValue(RedisServerConfig redisServerConfig, String key) {
        Set<String> values = new JedisExecutor(redisServerConfig).execute(new AllSet(key)).getValues();
        Iterable<Map> iterable = Iterables.transform(values, new Function<String, Map>() {
            @Override
            public Map apply(String s) {
                Map map = new HashMap();
                map.put("label", s);
                return map;
            }
        });
        return Sets.newHashSet(iterable);
    }

    @Override
    public void setSetValue(RedisServerConfig redisServerConfig, String key, Set<Map> values) {
        Iterable<String> iterable = Iterables.transform(values, new Function<Map, String>() {
            @Override
            public String apply(Map stringStringMap) {
                return String.valueOf(stringStringMap.get("label"));
            }
        });

        HashSet<String> hashSet = Sets.newHashSet(iterable);
        new JedisExecutor(redisServerConfig).execute(new UpdateSet(key, hashSet.toArray(new String[hashSet.size()])));
    }

    @Override
    public List<Map> getZSetValue(RedisServerConfig redisServerConfig, String key) {
        Set<Tuple> values = new JedisExecutor(redisServerConfig).execute(new AllZSet(key)).getValues();
        Iterable<Map> iterable = Iterables.transform(values, new Function<Tuple, Map>() {
            @Override
            public Map<String, Object> apply(Tuple tuple) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("score", tuple.getScore());
                map.put("element", tuple.getElement());
                return map;
            }
        });
        return Lists.newArrayList(iterable);
    }

    @Override
    public void setZSetValue(RedisServerConfig redisServerConfig, String key, List<Map> values) {
        Map map = MapListUtils.zSetList2Map(values, "element", "score");
        new JedisExecutor(redisServerConfig).execute(new UpdateZSet(key,map));
    }

    @Override
    public Long getIdletime(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new Idletime(key)).getIdleTime();
    }

    @Override
    public Long getTTLs(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new TTLs(key)).getSecond();
    }

    @Override
    public void setExpire(RedisServerConfig redisServerConfig, String key, int expire) {
        new JedisExecutor(redisServerConfig).execute(new Expire(key,expire));
    }
}
