package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.vo.RedisServerConfig;

public class RemoveServerConfigEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;

		public var responseFun:Function;
		
		public function RemoveServerConfigEvent(server:RedisServerConfig,responseFun:Function)
		{
			super("removeServerConfig");
			this.server = server;

			this.responseFun = responseFun;
		}
	}
}