package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.RemoveServerConfigDelegate;
	import com.izerui.event.RemoveServerConfigEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class RemoveServerConfigCommond implements IResponder, ICommand
	{
		
		private var delegate:RemoveServerConfigDelegate;
		
		private var responseFun:Function;
		
		public function RemoveServerConfigCommond()
		{
			delegate = new RemoveServerConfigDelegate(this);
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
			var myEvent:RemoveServerConfigEvent = RemoveServerConfigEvent(event);
			responseFun = myEvent.responseFun;
			delegate.removeServerConfig(myEvent.server);
		}
	}
}