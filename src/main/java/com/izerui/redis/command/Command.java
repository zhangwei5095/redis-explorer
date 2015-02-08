package com.izerui.redis.command;

import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public interface Command {
    /**
     * 执行redis命令
     * @param jedis
     */
    void command(Jedis jedis);
}
