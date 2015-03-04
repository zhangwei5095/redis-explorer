package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SetExpireDelegate;
	import com.izerui.event.SetExpireEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SetExpireCommond implements IResponder, ICommand
	{
		
		private var delegate:SetExpireDelegate;
		
		private var responseFun:Function;
		
		public function SetExpireCommond()
		{
			delegate = new SetExpireDelegate(this);
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
			var myEvent:SetExpireEvent = SetExpireEvent(event);
			responseFun = myEvent.responseFun;
			delegate.setExpire(myEvent.server,myEvent.key,myEvent.expire);
		}
	}
}