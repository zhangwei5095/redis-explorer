package com.izerui.redis.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.izerui.redis.command.JedisExecutor;
import com.izerui.redis.command.hash.ReadHash;
import com.izerui.redis.command.key.ListKeys;
import com.izerui.redis.command.list.AllList;
import com.izerui.redis.command.server.DbAmount;
import com.izerui.redis.command.set.AllSet;
import com.izerui.redis.command.string.ReadString;
import com.izerui.redis.command.zset.AllZSet;
import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;
import com.izerui.redis.repository.ServerConfigRepository;
import com.izerui.redis.service.RedisExplorerService;
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
    public String getStringValue(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new ReadString(key)).getValue();
    }

    @Override
    public List<Map<String, String>> getHashValue(RedisServerConfig redisServerConfig, String key) {
        List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();
        Map<String, String> map = new JedisExecutor(redisServerConfig).execute(new ReadHash(key)).getValue();
        for(Map.Entry<String,String> entry:map.entrySet()){
            Map<String,String> obj = new HashMap<String, String>();
            obj.put("key",entry.getKey());
            obj.put("value",entry.getValue());
            mapList.add(obj);
        }
        return mapList;
    }

    @Override
    public List<String> getListValue(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new AllList(key)).getValues();
    }

    @Override
    public Set<String> getSetValue(RedisServerConfig redisServerConfig, String key) {
        return new JedisExecutor(redisServerConfig).execute(new AllSet(key)).getValues();
    }

    @Override
    public List<String> getZSetValue(RedisServerConfig redisServerConfig, String key) {
        Set<Tuple> values = new JedisExecutor(redisServerConfig).execute(new AllZSet(key)).getValues();
        Iterable<String> transform = Iterables.transform(values, new Function<Tuple, String>() {
            @Override
            public String apply(Tuple tuple) {
                return tuple.getScore()+" , "+tuple.getElement();
            }
        });
        return Lists.newArrayList(transform);
    }
}
