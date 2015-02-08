package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
/**
 * Created by serv on 2015/2/8.
 */
public class InsertList extends KeyCommand {

	private LIST_POSITION where;
	private String pivot;
	private String value;

	public InsertList(String key, LIST_POSITION where, String pivot, String value) {
		super(key);
		this.where = where;
		this.pivot = pivot;
		this.value = value;
	}

	@Override
	public void command(Jedis jedis) {
		jedis.linsert(key, where, pivot, value);
	}

}
