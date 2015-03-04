package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class SetExpireEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;
		public var expire:int;

		public var responseFun:Function;
		
		public function SetExpireEvent(server:RedisServerConfig,key:String,expire:int,responseFun:Function)
		{
			super("setExpire");
					this.server = server;
			this.key = key;
			this.expire = expire;

			this.responseFun = responseFun;
		}
	}
}