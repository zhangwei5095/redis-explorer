package com.izerui.redis.command.set;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.List;

/**
 * Created by serv on 2015/2/8.
 */
public class PageSet extends KeyCommand {

    private int start;
    private int end;
    private List<String> values;

    public PageSet(String key, int start, int end) {
        super(key);
        this.start = start;
        this.end = end;
    }

    @Override
    public void command(Jedis jedis) {
        SortingParams sp = new SortingParams();
        sp.alpha();
        sp.limit(start, end-start);
        values = jedis.sort(key, sp);
    }

    public List<String> getValues() {
        return values;
    }
}
