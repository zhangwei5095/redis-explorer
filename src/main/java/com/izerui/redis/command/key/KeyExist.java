package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class KeyExist extends KeyCommand {

    private boolean exist;

    public KeyExist(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        exist = existKey(jedis);
    }

    public boolean isExist() {
        return exist;
    }
}
