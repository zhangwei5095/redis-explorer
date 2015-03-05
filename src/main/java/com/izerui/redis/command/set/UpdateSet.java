package com.izerui.redis.command.set;

import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/3/5.
 */
public class UpdateSet extends AddSet {

    public UpdateSet(String key, String[] values) {
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
