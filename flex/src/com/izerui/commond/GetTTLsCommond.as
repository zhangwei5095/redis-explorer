package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetTTLsDelegate;
	import com.izerui.event.GetTTLsEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetTTLsCommond implements IResponder, ICommand
	{
		
		private var delegate:GetTTLsDelegate;
		
		private var responseFun:Function;
		
		public function GetTTLsCommond()
		{
			delegate = new GetTTLsDelegate(this);
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
			var myEvent:GetTTLsEvent = GetTTLsEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getTTLs(myEvent.server,myEvent.key);
		}
	}
}