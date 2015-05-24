package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class DeleteKeyEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;

		public var responseFun:Function;
		
		public function DeleteKeyEvent(server:RedisServerConfig,key:String,responseFun:Function)
		{
			super("deleteKey");
					this.server = server;
			this.key = key;

			this.responseFun = responseFun;
		}
	}
}