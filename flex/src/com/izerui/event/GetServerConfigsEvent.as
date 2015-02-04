package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	import com.izerui.cairngorm.Controller;
	
	public class GetServerConfigsEvent extends CairngormEvent
	{

		public var responseFun:Function;
		
		public function GetServerConfigsEvent(responseFun:Function)
		{
			super(Controller.getServerConfigs);
			
			this.responseFun = responseFun;
		}
	}
}