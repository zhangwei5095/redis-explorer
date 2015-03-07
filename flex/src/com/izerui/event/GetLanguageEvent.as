package com.izerui.event
{
import com.adobe.cairngorm.control.CairngormEvent;

public class GetLanguageEvent extends CairngormEvent
	{

		public var responseFun:Function;
		
		public function GetLanguageEvent(responseFun:Function)
		{
			super("getLanguage");

			this.responseFun = responseFun;
		}
	}
}