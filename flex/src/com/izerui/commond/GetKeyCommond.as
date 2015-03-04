package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetKeyDelegate;
	import com.izerui.event.GetKeyEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetKeyCommond implements IResponder, ICommand
	{
		
		private var delegate:GetKeyDelegate;
		
		private var responseFun:Function;
		
		public function GetKeyCommond()
		{
			delegate = new GetKeyDelegate(this);
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
			var myEvent:GetKeyEvent = GetKeyEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getKey(myEvent.server,myEvent.key);
		}
	}
}