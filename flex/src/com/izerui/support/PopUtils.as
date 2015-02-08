package com.izerui.support
{
import flash.display.DisplayObject;

import mx.core.Application;
import mx.core.FlexGlobals;
import mx.core.IFlexDisplayObject;
import mx.managers.PopUpManager;

public class PopUtils
	{
		public function PopUtils()
		{
		}
		public static function popUp(window:IFlexDisplayObject,modal:Boolean=true):void{
			PopUpManager.addPopUp(window,DisplayObject(FlexGlobals.topLevelApplication),modal);
			PopUpManager.centerPopUp(window);
		}
		public static function removeUp(window:IFlexDisplayObject):void{
			PopUpManager.removePopUp(window);
		}
	}
}