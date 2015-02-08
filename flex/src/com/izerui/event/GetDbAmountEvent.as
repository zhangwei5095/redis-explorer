package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.vo.RedisServerConfig;

public class GetDbAmountEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;

		public var responseFun:Function;
		
		public function GetDbAmountEvent(server:RedisServerConfig,responseFun:Function)
		{
			super("getDbAmount");
					this.server = server;

			this.responseFun = responseFun;
		}
	}
}