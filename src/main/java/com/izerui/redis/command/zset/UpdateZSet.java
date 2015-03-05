package com.izerui.redis.command.zset;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by serv on 2015/3/5.
 */
public class UpdateZSet extends AddZSet {


    public UpdateZSet(String key, Map<String, Double> values) {
        super(key, values);
    }

    @Override
    public void command(Jedis jedis) {
        //先记录下超时时间
        int seconds = (int)getTtl(jedis);
        //删除key
        deleteKey(jedis);

        //添加
        super.command(jedis);

        //设置超时时间
        expire(jedis,seconds);
    }
}
