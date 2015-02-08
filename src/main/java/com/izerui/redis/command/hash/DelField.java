package com.izerui.redis.command.hash;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class DelField extends KeyCommand {

    private String[] fields;

    public DelField(String key, String... fields) {
        super(key);
        this.fields = fields;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.hdel(key, fields);
    }
}
