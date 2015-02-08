package com.izerui.redis.command.pubsub;

import com.izerui.redis.command.Command;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
/**
 * Created by serv on 2015/2/8.
 */
public class Subscribe  implements Command{
	private String channels;
	private JedisPubSub callback;

	public Subscribe(String channels, JedisPubSub callback) {
		this.channels = channels;
		this.callback = callback;
	}

	@Override
	public void command(Jedis jedis) {
		jedis.psubscribe(callback, channels);
	}
}
