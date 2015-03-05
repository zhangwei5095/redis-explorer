package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SetSetValueDelegate;
	import com.izerui.event.SetSetValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SetSetValueCommond implements IResponder, ICommand
	{
		
		private var delegate:SetSetValueDelegate;
		
		private var responseFun:Function;
		
		public function SetSetValueCommond()
		{
			delegate = new SetSetValueDelegate(this);
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
			var myEvent:SetSetValueEvent = SetSetValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.setSetValue(myEvent.server,myEvent.key,myEvent.values);
		}
	}
}