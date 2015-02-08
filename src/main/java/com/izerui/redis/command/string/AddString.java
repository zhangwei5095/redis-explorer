package com.izerui.redis.command.string;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class AddString extends KeyCommand {

    private String value;

    public AddString(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.set(key, value);
    }
}
