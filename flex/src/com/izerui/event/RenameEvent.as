package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class RenameEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;
		public var newKey:String;

		public var responseFun:Function;
		
		public function RenameEvent(server:RedisServerConfig,key:String,newKey:String,responseFun:Function)
		{
			super("rename");
					this.server = server;
			this.key = key;
			this.newKey = newKey;

			this.responseFun = responseFun;
		}
	}
}