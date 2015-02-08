package com.izerui.redis.command.key;

import com.izerui.redis.command.Command;
import com.izerui.redis.command.KeyCommand;
import com.izerui.redis.dto.Key;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Created by serv on 2015/2/8.
 */
public class ListKeys implements Command{

    private List<Key> keys = new ArrayList<Key>();

    @Override
    public void command(Jedis jedis) {
        Set<String> keySet = jedis.keys("*");
        String[] array = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(array);

        for(String key:array){
            KeyInfo keyInfo = new KeyInfo(key);
            keyInfo.command(jedis);
            keys.add(keyInfo.getKey());
        }

    }

    public List<Key> getKeys() {
        return keys;
    }
}
