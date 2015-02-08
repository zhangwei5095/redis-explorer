package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
import com.izerui.vo.RedisServerConfig;

import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class GetKeysDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function GetKeysDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("redisExplorerService");
		}
		
		public function getKeys(server:RedisServerConfig):void{
			var call:AsyncToken = service.getKeys(server);
			call.addResponder(responder);
		}
		
		public function result(data:Object):void
		{
			responder.result(data);
		}
		
		public function fault(info:Object):void
		{
			responder.fault(info);
		}
	}
}