package com.izerui.support
{
import flash.display.Sprite;

import mx.controls.Alert;
import mx.events.CloseEvent;

public class AlertUtils
	{
	public static function confirm(msg:String,msgTitle:String,dispObj:Object,callFunctionForOK:Function):void{
			Alert.okLabel="确定";
			Alert.cancelLabel="取消";
			Alert.show(msg,msgTitle,Alert.OK|Alert.CANCEL,dispObj as Sprite,myClick,null,Alert.OK);
			function myClick(evt:CloseEvent):void{
				if(evt.detail==Alert.OK){   //点了确认按钮
					if (callFunctionForOK){
						callFunctionForOK.call();
					}
				}   
			}
		}

	}
}