package com.izerui.redis.command.key;

import com.izerui.redis.command.Command;
import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Dump extends KeyCommand{

    private byte[] value;

    public Dump(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        value = jedis.dump(key);
    }

    public byte[] getValue() {
        return value;
    }

}
