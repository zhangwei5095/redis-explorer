package com.izerui.redis.service.impl;

import com.izerui.redis.entity.RedisServerConfig;
import com.izerui.redis.repository.ServerConfigRepository;
import com.izerui.redis.service.RedisExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
