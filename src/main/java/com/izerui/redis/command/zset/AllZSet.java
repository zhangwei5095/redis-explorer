package com.izerui.redis.command.zset;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Created by serv on 2015/2/8.
 */
public class AllZSet extends KeyCommand {

    private Set<Tuple> values;

    public AllZSet(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        values = jedis.zrangeWithScores(key, 0, -1);
    }

    public Set<Tuple> getValues() {
        return values;
    }
}
