package com.izerui.redis.service.impl;

import com.izerui.redis.command.JedisExecutor;
import com.izerui.redis.command.key.KeyInfo;
import com.izerui.redis.command.key.ListKeys;
import com.izerui.redis.command.server.DbAmount;
import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;
import com.izerui.redis.repository.ServerConfigRepository;
import com.izerui.redis.service.RedisExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
        List<RedisServerConfig> list = serverConfigRepository.findAll(new Sort(new Sort.Order("createTime")));
//        for (RedisServerConfig server:list){
//            addDbs(server);
//        }
        return list;

    }

    private void addDbs(RedisServerConfig server){
        if(server.getDisplayName()==null){
            server.setDisplayName(server.getHost());
        }
        server.setChildren(new ArrayList<RedisServerConfig>());
        for(int i=0;i<=15;i++){
            RedisServerConfig childrenItem = new RedisServerConfig();
            childrenItem.setId(server.getId());
            childrenItem.setHost(server.getHost());
            childrenItem.setDisplayName("db"+i);
            childrenItem.setId(server.getId());
            childrenItem.setPassword(server.getPassword());
            childrenItem.setPort(server.getPort());
            childrenItem.setDbIndex(i);
            server.getChildren().add(childrenItem);
        }
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
        JedisExecutor executor = new JedisExecutor(redisServerConfig);
        return executor.execute(new DbAmount()).getDbAmount();
    }

    @Override
    public List<Key> getKeys(RedisServerConfig redisServerConfig) {
        JedisExecutor executor = new JedisExecutor(redisServerConfig);
        return executor.execute(new ListKeys()).getKeys();
    }
}
