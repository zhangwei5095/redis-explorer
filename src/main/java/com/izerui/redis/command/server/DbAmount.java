package com.izerui.redis.command.server;

import com.izerui.redis.command.Command;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by serv on 2015/2/8.
 */
public class DbAmount implements Command{

    private int dbAmount;

    @Override
    public void command(Jedis jedis) {
        List<String> dbs = jedis.configGet("databases");
        if(dbs.size() > 0)
            dbAmount = Integer.parseInt(dbs.get(1));
        else
            dbAmount = 15;
    }

    public int getDbAmount() {
        return dbAmount;
    }

}
