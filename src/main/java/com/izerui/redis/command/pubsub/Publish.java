package com.izerui.redis.command.pubsub;

import com.izerui.redis.command.Command;
import redis.clients.jedis.Jedis;
/**
 * Created by serv on 2015/2/8.
 */
public class Publish implements Command {
	private String channel;
	private String message;

	public Publish(String channel, String message) {
		this.channel = channel;
		this.message = message;
	}

	@Override
	public void command(Jedis jedis) {
		jedis.publish(channel, message);
	}
}
