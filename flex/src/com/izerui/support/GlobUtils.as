package com.izerui.support
{
	import flash.desktop.Clipboard;
	import flash.desktop.ClipboardFormats;

	public class GlobUtils
	{
		public function GlobUtils()
		{
		}
		
		public static function copyValue(value:String):void{
			Clipboard.generalClipboard.clear();
			Clipboard.generalClipboard.setData(ClipboardFormats.TEXT_FORMAT,value,false);
		}
	}
}