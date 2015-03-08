package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.LoginDelegate;
	import com.izerui.event.LoginEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class LoginCommond implements IResponder, ICommand
	{
		
		private var delegate:LoginDelegate;
		
		private var responseFun:Function;
		
		public function LoginCommond()
		{
			delegate = new LoginDelegate(this);
		}
		
		public function result(data:Object):void
		{
			if(responseFun){
				responseFun.call(null,data.result);
			}
		}
		
		public function fault(info:Object):void
		{
			Alert.show(info.toString(),"提示");
		}
		
		public function execute(event:CairngormEvent):void
		{
			var myEvent:LoginEvent = LoginEvent(event);
			responseFun = myEvent.responseFun;
			delegate.login(myEvent.username,myEvent.password);
		}
	}
}