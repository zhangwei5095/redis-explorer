package com.izerui.redis.command.server;

import com.izerui.redis.command.Command;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by serv on 2015/2/8.
 */
public class ServerProperties implements Command {

	private Map<String, String[]> serverInfo = new HashMap<String, String[]>();
	
	@Override
	public void command(Jedis jedis) {
		String info = jedis.info();
		String[] tabs = info.split("#");

		for(String tab: tabs){
			if(tab.length() > 0){
				String[] keys = tab.split("\r\n");
				String[] values = new String[keys.length-1];
				for(int i = 1; i < keys.length; i ++) {
					values[i-1] = keys[i];
				}
				serverInfo.put(keys[0], values);
			}
		}
	}

	public Map<String, String[]> getServerInfo() {
		return serverInfo;
	}
}
