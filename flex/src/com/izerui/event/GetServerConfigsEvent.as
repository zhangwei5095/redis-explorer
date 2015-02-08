package com.izerui.event
{
	import com.adobe.cairngorm.control.CairngormEvent;
	
	public class GetServerConfigsEvent extends CairngormEvent
	{

		public var responseFun:Function;
		
		public function GetServerConfigsEvent(responseFun:Function)
		{
			super("getServerConfigs");
			
			this.responseFun = responseFun;
		}
	}
}