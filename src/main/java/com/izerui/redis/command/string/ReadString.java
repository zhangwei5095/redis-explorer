package com.izerui.redis.command.string;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class ReadString extends KeyCommand {

    private String value;

    public ReadString(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        value = jedis.get(key);
    }

    public String getValue() {
        return value;
    }
}
