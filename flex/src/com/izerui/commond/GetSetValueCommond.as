package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetSetValueDelegate;
	import com.izerui.event.GetSetValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetSetValueCommond implements IResponder, ICommand
	{
		
		private var delegate:GetSetValueDelegate;
		
		private var responseFun:Function;
		
		public function GetSetValueCommond()
		{
			delegate = new GetSetValueDelegate(this);
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
			var myEvent:GetSetValueEvent = GetSetValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getSetValue(myEvent.server,myEvent.key);
		}
	}
}