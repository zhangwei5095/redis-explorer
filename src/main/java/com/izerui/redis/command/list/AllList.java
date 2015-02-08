package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.List;
/**
 * Created by serv on 2015/2/8.
 */
public class AllList extends KeyCommand {

	private List<String> values;
	
	public AllList(String key) {
		super(key);
	}

	@Override
	public void command(Jedis jedis) {
		values = jedis.lrange(key, 0, -1);
	}

	public List<String> getValues() {
		return values;
	}
}
