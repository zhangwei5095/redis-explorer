package com.izerui.redis.command.hash;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by serv on 2015/2/8.
 */
public class FieldExist extends KeyCommand {

    private String field;
    private boolean exist;

    public FieldExist(String key, String field) {
        super(key);
        this.field = field;
    }

    @Override
    public void command(Jedis jedis) {
        Set<String> fields = jedis.hkeys(key);
        exist = fields.contains(field);
    }

    public boolean isExist() {
        return exist;
    }
}
