package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetListValueDelegate;
	import com.izerui.event.GetListValueEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetListValueCommond implements IResponder, ICommand
	{
		
		private var delegate:GetListValueDelegate;
		
		private var responseFun:Function;
		
		public function GetListValueCommond()
		{
			delegate = new GetListValueDelegate(this);
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
			var myEvent:GetListValueEvent = GetListValueEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getListValue(myEvent.server,myEvent.key);
		}
	}
}