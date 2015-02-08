package com.izerui.redis.command;

import com.izerui.redis.RedisException;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public abstract class KeyCommand implements Command {

    protected String key;

    public KeyCommand(String key) {
        this.key = key;
    }

    protected boolean existKey(Jedis jedis){
        return jedis.exists(key);
    }

    protected long getTtl(Jedis jedis){
        return jedis.ttl(key);
    }

    protected void deleteKey(Jedis jedis){
        jedis.del(key);
    }

    protected void expire(Jedis jedis,int seconds){
        jedis.expire(key,seconds);
    }

    /**
     * 检查存在的key是否是指定类型
     * @param jedis
     * @param type
     */
    protected void validateExistKeyType(Jedis jedis, String type) {

        if(existKey(jedis)){
            String keyType = jedis.type(key);
            if(!keyType.equals(type)){
                throw new RedisException(key+"类型检查出错");
            }
        }

    }
}
