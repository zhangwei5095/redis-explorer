package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.vo.RedisServerConfig;

public class GetKeysEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;

		public var responseFun:Function;
		
		public function GetKeysEvent(server:RedisServerConfig,responseFun:Function)
		{
			super("getKeys");
					this.server = server;

			this.responseFun = responseFun;
		}
	}
}