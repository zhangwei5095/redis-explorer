package com.izerui.redis.service;

import com.izerui.redis.dto.Key;
import com.izerui.redis.entity.RedisServerConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by serv on 2015/2/3.
 */
public interface RedisExplorerService{
    String getLanguage();
    List<RedisServerConfig> getServerConfigs();
    RedisServerConfig saveServerConfig(RedisServerConfig redisServerConfig);
    void removeServerConfig(RedisServerConfig redisServerConfig);
    int getDbAmount(RedisServerConfig redisServerConfig);
    List<Key> getKeys(RedisServerConfig redisServerConfig);
    Key getKey(RedisServerConfig redisServerConfig,String key);
    String getStringValue(RedisServerConfig redisServerConfig,String key);
    void saveStringValue(RedisServerConfig redisServerConfig,String key,String value);
    List<Map> getHashValue(RedisServerConfig redisServerConfig,String key);
    void saveHashValue(RedisServerConfig redisServerConfig,String key,List<Map> mapList);
    List<Map> getListValue(RedisServerConfig redisServerConfig,String key);
    void setListValue(RedisServerConfig redisServerConfig,String key,List<Map> values);
    Set<Map> getSetValue(RedisServerConfig redisServerConfig,String key);
    void setSetValue(RedisServerConfig redisServerConfig,String key,Set<Map> values);
    List<Map> getZSetValue(RedisServerConfig redisServerConfig, String key);
    void setZSetValue(RedisServerConfig redisServerConfig, String key,List<Map> values);
    Long getIdletime(RedisServerConfig redisServerConfig, String key);
    Long getTTLs(RedisServerConfig redisServerConfig, String key);
    void setExpire(RedisServerConfig redisServerConfig, String key,int expire);
}
