package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
import com.izerui.business.BaseDelegate;
import com.izerui.vo.RedisServerConfig;

import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	
	public class GetDbAmountDelegate extends BaseDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function GetDbAmountDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = getRemoteObject("redisExplorerService");
		}
		
		public function getDbAmount(server:RedisServerConfig):void{
			var call:AsyncToken = service.getDbAmount(server);
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