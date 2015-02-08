package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Restore extends KeyCommand {

    private byte[] value;

    public Restore(String key, byte[] value) {
        super(key);
        this.value = value;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.restore(key, 0, value);
    }
}
