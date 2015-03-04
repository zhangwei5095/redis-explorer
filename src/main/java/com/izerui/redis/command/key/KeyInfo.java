package com.izerui.redis.command.key;

import com.izerui.redis.command.KeyCommand;
import com.izerui.redis.dto.Key;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public class KeyInfo extends KeyCommand {

    private Key keyInfo;

    public KeyInfo(String key) {
        super(key);
    }

    @Override
    public void command(Jedis jedis) {
        keyInfo = new Key();
        keyInfo.setName(key);
        keyInfo.setSize(getSize(jedis));
        keyInfo.setType(getType(jedis));
        keyInfo.setTtls(getTtl(jedis));
    }

    public Key getKey() {
        return keyInfo;
    }
}
