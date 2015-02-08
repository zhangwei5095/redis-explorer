package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class TTLs extends KeyCommand {

    private long second;

    public TTLs(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        second = jedis.ttl(key);
    }

    public long getSecond() {
        return second;
    }
}
