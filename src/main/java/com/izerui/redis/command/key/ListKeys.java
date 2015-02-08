package com.izerui.redis.command.key;

import com.izerui.redis.command.Command;
import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by serv on 2015/2/8.
 */
public class ListKeys implements Command{

    private Set<String> keys;

    @Override
    public void command(Jedis jedis) {
        keys = jedis.keys("*");
    }

    public Set<String> getKeys() {
        return keys;
    }
}
