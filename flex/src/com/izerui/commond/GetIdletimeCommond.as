package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetIdletimeDelegate;
	import com.izerui.event.GetIdletimeEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetIdletimeCommond implements IResponder, ICommand
	{
		
		private var delegate:GetIdletimeDelegate;
		
		private var responseFun:Function;
		
		public function GetIdletimeCommond()
		{
			delegate = new GetIdletimeDelegate(this);
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
			var myEvent:GetIdletimeEvent = GetIdletimeEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getIdletime(myEvent.server,myEvent.key);
		}
	}
}