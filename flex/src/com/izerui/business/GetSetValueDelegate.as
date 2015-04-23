package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	import com.izerui.vo.RedisServerConfig;
	
	public class GetSetValueDelegate extends BaseDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function GetSetValueDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = getRemoteObject("redisExplorerService");
		}
		
		public function getSetValue(server:RedisServerConfig,key:String):void{
			var call:AsyncToken = service.getSetValue(server,key);
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