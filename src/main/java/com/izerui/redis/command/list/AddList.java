package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by serv on 2015/2/8.
 */
public class AddList extends KeyCommand {

	private List<String> values;

	public AddList(String key, List<String> values) {
		super(key);
		this.values = values;
	}

	@Override
	public void command(Jedis jedis) {
		super.validateExistKeyType(jedis, "list");
		jedis.rpush(key,values.toArray(new String[values.size()]));

	}


}
