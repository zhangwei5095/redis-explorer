package com.izerui.redis.command.zset;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by serv on 2015/2/8.
 */
public class AddZSet extends KeyCommand{

    protected Map<String, Double> values;

    public AddZSet(String key, Map<String, Double> values) {
        super(key);
        this.values = values;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.zadd(key, values);
    }
}
