package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class SaveHashValueEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;
		public var map:Object;

		public var responseFun:Function;
		
		public function SaveHashValueEvent(server:RedisServerConfig,key:String,map:Object,responseFun:Function)
		{
			super("saveHashValue");
					this.server = server;
			this.key = key;
			this.map = map;

			this.responseFun = responseFun;
		}
	}
}