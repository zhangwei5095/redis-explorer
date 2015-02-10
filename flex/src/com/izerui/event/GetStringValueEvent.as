package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class GetStringValueEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;

		public var responseFun:Function;
		
		public function GetStringValueEvent(server:RedisServerConfig,key:String,responseFun:Function)
		{
			super("getStringValue");
					this.server = server;
			this.key = key;

			this.responseFun = responseFun;
		}
	}
}