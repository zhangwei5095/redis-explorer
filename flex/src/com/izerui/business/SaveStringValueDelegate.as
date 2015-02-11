package com.izerui.business
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	import mx.rpc.remoting.RemoteObject;
	import com.izerui.vo.RedisServerConfig;
	
	public class SaveStringValueDelegate implements IResponder
	{
		private var responder:IResponder;
		private var service:RemoteObject;
		
		public function SaveStringValueDelegate(responder:IResponder)
		{
			this.responder = responder;
			this.service = ServiceLocator.getInstance().getRemoteObject("redisExplorerService");
		}
		
		public function saveStringValue(server:RedisServerConfig,key:String,value:String):void{
			var call:AsyncToken = service.saveStringValue(server,key,value);
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