package com.izerui.redis.command.string;

import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class UpdateString extends AddString{

    public UpdateString(String key, String value) {
        super(key, value);
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
