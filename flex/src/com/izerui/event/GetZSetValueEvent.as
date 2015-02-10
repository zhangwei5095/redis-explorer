package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class GetZSetValueEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;

		public var responseFun:Function;
		
		public function GetZSetValueEvent(server:RedisServerConfig,key:String,responseFun:Function)
		{
			super("getZSetValue");
					this.server = server;
			this.key = key;

			this.responseFun = responseFun;
		}
	}
}