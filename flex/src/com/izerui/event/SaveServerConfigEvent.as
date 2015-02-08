package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class SaveServerConfigEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;

		public var responseFun:Function;
		
		public function SaveServerConfigEvent(server:RedisServerConfig,responseFun:Function)
		{
			super("saveServerConfig");
			this.server = server;

			this.responseFun = responseFun;
		}
	}
}