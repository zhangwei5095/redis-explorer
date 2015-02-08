package com.izerui.redis.service;

import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;

import java.util.List;
import java.util.Set;

/**
 * Created by serv on 2015/2/3.
 */
public interface RedisExplorerService{
    List<RedisServerConfig> getServerConfigs();
    RedisServerConfig saveServerConfig(RedisServerConfig redisServerConfig);
    void removeServerConfig(RedisServerConfig redisServerConfig);
    int getDbAmount(RedisServerConfig redisServerConfig);
    List<Key> getKeys(RedisServerConfig redisServerConfig);
}
