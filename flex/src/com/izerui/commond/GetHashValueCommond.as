package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetHashValueDelegate;
	import com.izerui.event.GetHashValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetHashValueCommond implements IResponder, ICommand
	{
		
		private var delegate:GetHashValueDelegate;
		
		private var responseFun:Function;
		
		public function GetHashValueCommond()
		{
			delegate = new GetHashValueDelegate(this);
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
			var myEvent:GetHashValueEvent = GetHashValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getHashValue(myEvent.server,myEvent.key);
		}
	}
}