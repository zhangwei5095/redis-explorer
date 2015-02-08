package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.SaveServerConfigDelegate;
	import com.izerui.event.SaveServerConfigEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class SaveServerConfigCommond implements IResponder, ICommand
	{
		
		private var delegate:SaveServerConfigDelegate;
		
		private var responseFun:Function;
		
		public function SaveServerConfigCommond()
		{
			delegate = new SaveServerConfigDelegate(this);
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
			var myEvent:SaveServerConfigEvent = SaveServerConfigEvent(event);
			responseFun = myEvent.responseFun;
			delegate.saveServerConfig(myEvent.server);
		}
	}
}