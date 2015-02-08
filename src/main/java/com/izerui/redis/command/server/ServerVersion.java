package com.izerui.redis.command.server;

import com.izerui.redis.command.Command;
import redis.clients.jedis.Jedis;
/**
 * Created by serv on 2015/2/8.
 */
public class ServerVersion implements Command {

	private String version;

	@Override
	public void command(Jedis jedis) {
		String info = jedis.info();
		String[] infos = info.split("\r\n");

		for(int i = 0; i < infos.length; i++) {
			if(infos[i].startsWith("redis_version:")){
				String[] versionInfo = infos[i].split(":");
				version = versionInfo[1];
				break;
			}
		}
	}

	public String getVersion() {
		return version;
	}
}
