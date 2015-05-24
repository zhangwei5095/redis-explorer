package com.izerui.commond
{
	import com.adobe.cairngorm.commands.ICommand;
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.business.DeleteKeyDelegate;
	import com.izerui.event.DeleteKeyEvent;
	import mx.controls.Alert;
	import mx.rpc.IResponder;
	
	public class DeleteKeyCommond implements IResponder, ICommand
	{
		
		private var delegate:DeleteKeyDelegate;
		
		private var responseFun:Function;
		
		public function DeleteKeyCommond()
		{
			delegate = new DeleteKeyDelegate(this);
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
			var myEvent:DeleteKeyEvent = DeleteKeyEvent(event);
			responseFun = myEvent.responseFun;
			delegate.deleteKey(myEvent.server,myEvent.key);
		}
	}
}