package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SetZSetValueDelegate;
	import com.izerui.event.SetZSetValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SetZSetValueCommond implements IResponder, ICommand
	{
		
		private var delegate:SetZSetValueDelegate;
		
		private var responseFun:Function;
		
		public function SetZSetValueCommond()
		{
			delegate = new SetZSetValueDelegate(this);
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
			var myEvent:SetZSetValueEvent = SetZSetValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.setZSetValue(myEvent.server,myEvent.key,myEvent.values);
		}
	}
}