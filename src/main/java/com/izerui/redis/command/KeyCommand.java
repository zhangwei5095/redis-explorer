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

    protected long getSize(Jedis jedis){
        long size ;
        String type = getType(jedis);
        if (type.equals("string"))
            size = (long) 1;
        else if (type.equals("hash"))
            size = jedis.hlen(key);
        else if (type.equals("list"))
            size = jedis.llen(key);
        else if (type.equals("set"))
            size = jedis.scard(key);
        else
            size = jedis.zcard(key);
        return size;
    }

    protected String getType(Jedis jedis){
        return jedis.type(key);
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
        if(seconds<=0){
            return;
        }
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
