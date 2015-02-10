package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.GetDbAmountDelegate;
	import com.izerui.event.GetDbAmountEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class GetDbAmountCommond implements IResponder, ICommand
	{
		
		private var delegate:GetDbAmountDelegate;
		
		private var responseFun:Function;
		
		public function GetDbAmountCommond()
		{
			delegate = new GetDbAmountDelegate(this);
		}
		
		public function result(data:Object):void
		{
			if(responseFun){
				responseFun.call(null,data.result);
			}
		}
		
		public function fault(info:Object):void
		{
			Alert.show("连接redis服务器异常!","提示");
		}
		
		public function execute(event:CairngormEvent):void
		{
			var myEvent:GetDbAmountEvent = GetDbAmountEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getDbAmount(myEvent.server);
		}
	}
}