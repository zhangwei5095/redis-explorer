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
    Key getKey(RedisServerConfig redisServerConfig,String key);
    String getStringValue(RedisServerConfig redisServerConfig,String key);
    void saveStringValue(RedisServerConfig redisServerConfig,String key,String value);
    List<Map<String, String>> getHashValue(RedisServerConfig redisServerConfig,String key);
    void saveHashValue(RedisServerConfig redisServerConfig,String key,List<Map<String, String>> mapList);
    List<Map<String, String>> getListValue(RedisServerConfig redisServerConfig,String key);
    void setListValue(RedisServerConfig redisServerConfig,String key,List<Map<String, String>> values);
    Set<String> getSetValue(RedisServerConfig redisServerConfig,String key);
    List<String> getZSetValue(RedisServerConfig redisServerConfig, String key);
    Long getIdletime(RedisServerConfig redisServerConfig, String key);
    Long getTTLs(RedisServerConfig redisServerConfig, String key);
    void setExpire(RedisServerConfig redisServerConfig, String key,int expire);
}
