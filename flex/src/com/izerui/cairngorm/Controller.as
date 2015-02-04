package com.izerui.cairngorm
{
import com.adobe.cairngorm.control.FrontController;
import com.izerui.module.tree.commond.GetServerConfigsCommond;

public class Controller extends FrontController
	{
		public static var getServerConfigs:String = "getServerConfigs";

		public function Controller()
		{
			this.addCommand(getServerConfigs,GetServerConfigsCommond);
		}
	}
}