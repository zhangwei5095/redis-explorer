package com.izerui.redis.service;

import com.izerui.redis.entity.RedisServerConfig;

import java.util.List;

/**
 * Created by serv on 2015/2/3.
 */
public interface RedisExplorerService{
    List<RedisServerConfig> getServerConfigs();
    RedisServerConfig saveServerConfig(RedisServerConfig redisServerConfig);
    void removeServerConfig(RedisServerConfig redisServerConfig);
}
