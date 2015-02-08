package com.izerui.redis.command.hash;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class SetField extends KeyCommand {

    private String field;
    private String value;

    public SetField(String key, String field, String value) {
        super(key);
        this.field = field;
        this.value = value;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.hset(key, field, value);
    }
}
