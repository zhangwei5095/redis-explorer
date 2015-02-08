package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Encoding extends KeyCommand {

    private String encoding;

    public Encoding(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        encoding = jedis.objectEncoding(key);
    }

    public String getEncoding() {
        return encoding;
    }
}
