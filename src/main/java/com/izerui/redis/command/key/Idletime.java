package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Idletime extends KeyCommand {

    private Long idleTime;

    public Idletime(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        idleTime = jedis.objectIdletime(key);
    }

    public Long getIdleTime() {
        return idleTime;
    }
}
