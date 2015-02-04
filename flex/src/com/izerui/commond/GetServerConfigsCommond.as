package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetServerConfigsDelegate;
	import com.izerui.event.GetServerConfigsEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetServerConfigsCommond implements IResponder, ICommand
	{
		
		private var delegate:GetServerConfigsDelegate;
		
		private var responseFun:Function;
		
		public function GetServerConfigsCommond()
		{
			delegate = new GetServerConfigsDelegate(this);
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
			var myEvent:GetServerConfigsEvent = GetServerConfigsEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getServerConfigs();
		}
	}
}