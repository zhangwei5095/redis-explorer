package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.RenameDelegate;
	import com.izerui.event.RenameEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class RenameCommond implements IResponder, ICommand
	{
		
		private var delegate:RenameDelegate;
		
		private var responseFun:Function;
		
		public function RenameCommond()
		{
			delegate = new RenameDelegate(this);
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
			var myEvent:RenameEvent = RenameEvent(event);
			responseFun = myEvent.responseFun;
			delegate.rename(myEvent.server,myEvent.key,myEvent.newKey);
		}
	}
}