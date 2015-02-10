package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetStringValueDelegate;
	import com.izerui.event.GetStringValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetStringValueCommond implements IResponder, ICommand
	{
		
		private var delegate:GetStringValueDelegate;
		
		private var responseFun:Function;
		
		public function GetStringValueCommond()
		{
			delegate = new GetStringValueDelegate(this);
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
			var myEvent:GetStringValueEvent = GetStringValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getStringValue(myEvent.server,myEvent.key);
		}
	}
}