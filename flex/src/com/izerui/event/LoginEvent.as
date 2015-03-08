package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.vo.RedisServerConfig;
	
	public class LoginEvent extends CairngormEvent
	{
		public var username:String;
		public var password:String;

		public var responseFun:Function;
		
		public function LoginEvent(username:String,password:String,responseFun:Function)
		{
			super("login");
					this.username = username;
			this.password = password;

			this.responseFun = responseFun;
		}
	}
}