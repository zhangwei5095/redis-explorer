package com.izerui.redis.command.zset;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class RemoveMembers extends KeyCommand {

    private String[] members;

    public RemoveMembers(String key, String[] members) {
        super(key);
        this.members = members;
    }

    @Override
    public void command(Jedis jedis) {
        jedis.zrem(key, members);
    }
}
