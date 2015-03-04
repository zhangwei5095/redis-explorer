package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SetListValueDelegate;
	import com.izerui.event.SetListValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SetListValueCommond implements IResponder, ICommand
	{
		
		private var delegate:SetListValueDelegate;
		
		private var responseFun:Function;
		
		public function SetListValueCommond()
		{
			delegate = new SetListValueDelegate(this);
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
			var myEvent:SetListValueEvent = SetListValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.setListValue(myEvent.server,myEvent.key,myEvent.values);
		}
	}
}