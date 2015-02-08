package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;
/**
 * Created by serv on 2015/2/8.
 */
public class SetValue extends KeyCommand {
	private int index;
	private String value;

	public SetValue(String key, int index, String value) {
		super(key);
		this.index = index;
		this.value = value;
	}

	@Override
	public void command(Jedis jedis) {
		jedis.lset(key, index, value);
	}

}
