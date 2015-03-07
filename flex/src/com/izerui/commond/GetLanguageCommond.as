package com.izerui.commond
{
import com.adobe.cairngorm.commands.ICommand;
import com.adobe.cairngorm.control.CairngormEvent;
import com.izerui.business.GetLanguageDelegate;
import com.izerui.event.GetLanguageEvent;

import mx.controls.Alert;
import mx.rpc.IResponder;

public class GetLanguageCommond implements IResponder, ICommand
	{
		
		private var delegate:GetLanguageDelegate;
		
		private var responseFun:Function;
		
		public function GetLanguageCommond()
		{
			delegate = new GetLanguageDelegate(this);
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
			var myEvent:GetLanguageEvent = GetLanguageEvent(event);
			responseFun = myEvent.responseFun;
			delegate.getLanguage();
		}
	}
}