package com.izerui.redis.command;

import com.izerui.redis.entity.RedisServerConfig;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class JedisExecutor {

    private Jedis jedis = null;

    public JedisExecutor(RedisServerConfig server) {
        jedis = new Jedis(server.getHost(), server.getPort(), 100);
        if (server.getPassword() != null && server.getPassword().length() > 0) {
            jedis.auth(server.getPassword());
        }
        jedis.select(server.getDbIndex());
    }

    public <T extends Command> T execute(T command) {
        command.command(jedis);
        return command;
    }

}
