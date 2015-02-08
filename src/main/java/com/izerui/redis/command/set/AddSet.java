package com.izerui.redis.command.set;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class AddSet extends KeyCommand {

    private String[] values;

    public AddSet(String key, String[] values) {
        super(key);
        this.values = values;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.sadd(key, values);
    }

}
