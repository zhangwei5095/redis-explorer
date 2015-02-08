package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Refcount extends KeyCommand {

    private Long count;

    public Refcount(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        count = jedis.objectRefcount(key);
    }

    public Long getCount() {
        return count;
    }
}
