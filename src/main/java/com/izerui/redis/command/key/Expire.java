package com.izerui.redis.command.key;

import com.izerui.redis.command.Command;
import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Expire extends KeyCommand {

    /**
     * 当为-1表示设置key持久
     */
    private int second;

    public Expire(String key, int second) {
        super(key);
        this.second = second;
    }

    @Override
    public void command(Jedis jedis) {
        if(second != -1)
            jedis.expire(key, second);
        else
            jedis.persist(key);
    }
}
