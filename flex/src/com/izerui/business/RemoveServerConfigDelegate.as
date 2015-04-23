package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
import com.izerui.vo.RedisServerConfig;

import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class RemoveServerConfigDelegate extends BaseDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function RemoveServerConfigDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = getRemoteObject("redisExplorerService");
		}
		
		public function removeServerConfig(server:RedisServerConfig):void{
			var call:AsyncToken = service.removeServerConfig(server);
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