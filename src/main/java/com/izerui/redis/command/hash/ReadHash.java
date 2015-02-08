package com.izerui.redis.command.hash;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by serv on 2015/2/8.
 */
public class ReadHash extends KeyCommand {


    private Map<String, String> value;

    public ReadHash(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        value = jedis.hgetAll(key);
    }

    public Map<String, String> getValue() {
        return value;
    }
}
