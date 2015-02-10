package com.izerui.redis.service;

import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;
import redis.clients.jedis.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    String getStringValue(RedisServerConfig redisServerConfig,String key);
    List<Map<String, String>> getHashValue(RedisServerConfig redisServerConfig,String key);
    List<String> getListValue(RedisServerConfig redisServerConfig,String key);
    Set<String> getSetValue(RedisServerConfig redisServerConfig,String key);
    List<String> getZSetValue(RedisServerConfig redisServerConfig, String key);
}
