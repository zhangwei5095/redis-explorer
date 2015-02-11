package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class SaveStringValueEvent extends CairngormEvent
	{
		public var server:RedisServerConfig;
		public var key:String;
		public var value:String;

		public var responseFun:Function;
		
		public function SaveStringValueEvent(server:RedisServerConfig,key:String,value:String,responseFun:Function)
		{
			super("saveStringValue");
					this.server = server;
			this.key = key;
			this.value = value;

			this.responseFun = responseFun;
		}
	}
}