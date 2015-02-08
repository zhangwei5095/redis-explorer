package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class Rename extends KeyCommand {

    private String newKey;
    private boolean overwritten;
    private Long result;

    public Rename(String oldkey, String newKey, boolean overwritten) {
        super(oldkey);
        this.newKey = newKey;
        this.overwritten = overwritten;
    }

    @Override
    public void command(Jedis jedis) {
        if(overwritten)
            jedis.rename(key, newKey);
        else
            result = jedis.renamenx(key, newKey);
    }

    public Long getResult() {
        return result;
    }
}
