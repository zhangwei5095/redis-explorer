package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class SetSetValueEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;
		public var values:Object;

		public var responseFun:Function;
		
		public function SetSetValueEvent(server:RedisServerConfig,key:String,values:Object,responseFun:Function)
		{
			super("setSetValue");
					this.server = server;
			this.key = key;
			this.values = values;

			this.responseFun = responseFun;
		}
	}
}