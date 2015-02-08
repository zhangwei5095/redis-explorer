package com.izerui.redis.command.list;

import com.izerui.redis.command.KeyCommand;
import redis.clients.jedis.Jedis;

import java.util.List;
/**
 * Created by serv on 2015/2/8.
 */
public class PageList extends KeyCommand {

	private int start;
	private int end;
	private List<String> page;

	public PageList(String key, int start, int end) {
		super(key);
		this.start = start;
		this.end = end;
	}

	@Override
	public void command(Jedis jedis) {
		page = jedis.lrange(key, start, end);
	}

	public List<String> getPage() {
		return page;
	}
}
