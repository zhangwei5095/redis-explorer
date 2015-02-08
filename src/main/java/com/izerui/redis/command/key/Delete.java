package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Delete extends KeyCommand {

    public Delete(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        jedis.del(key);
    }
}
