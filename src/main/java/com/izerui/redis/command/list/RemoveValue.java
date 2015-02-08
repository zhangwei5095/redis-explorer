package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;
/**
 * Created by serv on 2015/2/8.
 */
public class RemoveValue extends KeyCommand {

	private boolean lpop;

	public RemoveValue(String key, boolean lpop) {
		super(key);
		this.lpop = lpop;
	}

	@Override
	public void command(Jedis jedis) {
		if(lpop){
			jedis.lpop(key);
		} else {
			jedis.rpop(key);
		}
	}

}
