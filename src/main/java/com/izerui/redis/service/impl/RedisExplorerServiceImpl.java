package com.izerui.redis.service.impl;

import com.izerui.redis.entity.ServerConfig;
import com.izerui.redis.repository.ServerConfigRepository;
import com.izerui.redis.service.RedisExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<ServerConfig> getServerConfigs() {
        return serverConfigRepository.findAll();
    }
}
