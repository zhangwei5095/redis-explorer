package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetZSetValueDelegate;
	import com.izerui.event.GetZSetValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetZSetValueCommond implements IResponder, ICommand
	{
		
		private var delegate:GetZSetValueDelegate;
		
		private var responseFun:Function;
		
		public function GetZSetValueCommond()
		{
			delegate = new GetZSetValueDelegate(this);
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
			var myEvent:GetZSetValueEvent = GetZSetValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getZSetValue(myEvent.server,myEvent.key);
		}
	}
}