package com.izerui.redis.command.list;

import com.izerui.redis.command.key.Delete;
import com.izerui.redis.command.key.Expire;
import com.izerui.redis.command.key.TTLs;
import redis.clients.jedis.Jedis;

import java.util.List;
/**
 * Created by serv on 2015/2/8.
 */
public class UpdateList extends AddList {

	public UpdateList(String key, List<String> values) {
		super(key, values);
	}

	@Override
	public void command(Jedis jedis) {
		//先记录下超时时间
		int seconds = (int)getTtl(jedis);
		//删除key
		deleteKey(jedis);

		//添加
		super.command(jedis);

		//设置超时时间
		expire(jedis,seconds);
	}


}
