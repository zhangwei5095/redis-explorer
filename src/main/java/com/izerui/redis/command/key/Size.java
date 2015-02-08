package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Size extends KeyCommand {

    private long size;

    public Size(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        String type = jedis.type(key);
        if (type.equals("string"))
            size = (long) 1;
        else if (type.equals("hash"))
            size = jedis.hlen(key);
        else if (type.equals("list"))
            size = jedis.llen(key);
        else if (type.equals("set"))
            size = jedis.scard(key);
        else
            size = jedis.zcard(key);
    }

    public long getSize() {
        return size;
    }
}
