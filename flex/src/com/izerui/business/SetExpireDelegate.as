package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	import com.izerui.vo.RedisServerConfig;
	
	public class SetExpireDelegate extends BaseDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function SetExpireDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = getRemoteObject("redisExplorerService");
		}
		
		public function setExpire(server:RedisServerConfig,key:String,expire:int):void{
			var call:AsyncToken = service.setExpire(server,key,expire);
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