package com.izerui.redis.command.set;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by serv on 2015/2/8.
 */
public class AllSet extends KeyCommand{

    private Set<String> values;

    public AllSet(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        values = jedis.smembers(key);
    }

    public Set<String> getValues() {
        return values;
    }
}
