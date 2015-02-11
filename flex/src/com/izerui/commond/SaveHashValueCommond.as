package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SaveHashValueDelegate;
	import com.izerui.event.SaveHashValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SaveHashValueCommond implements IResponder, ICommand
	{
		
		private var delegate:SaveHashValueDelegate;
		
		private var responseFun:Function;
		
		public function SaveHashValueCommond()
		{
			delegate = new SaveHashValueDelegate(this);
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
			var myEvent:SaveHashValueEvent = SaveHashValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.saveHashValue(myEvent.server,myEvent.key,myEvent.map);
		}
	}
}