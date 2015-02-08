package com.izerui.redis.command.hash;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by serv on 2015/2/8.
 */
public class AddHash extends KeyCommand {

    private Map<String, String> values;

    public AddHash(String key, Map<String, String> values) {
        super(key);
        this.values = values;
    }

    @Override
    public void command(Jedis jedis) {
        super.validateExistKeyType(jedis, "hash");
        jedis.hmset(key, values);
    }
}
