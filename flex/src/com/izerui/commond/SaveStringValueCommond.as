package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SaveStringValueDelegate;
	import com.izerui.event.SaveStringValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SaveStringValueCommond implements IResponder, ICommand
	{
		
		private var delegate:SaveStringValueDelegate;
		
		private var responseFun:Function;
		
		public function SaveStringValueCommond()
		{
			delegate = new SaveStringValueDelegate(this);
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
			var myEvent:SaveStringValueEvent = SaveStringValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.saveStringValue(myEvent.server,myEvent.key,myEvent.value);
		}
	}
}