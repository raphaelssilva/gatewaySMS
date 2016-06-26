package biz.r2s.sms.gateway

import biz.r2s.sms.gateway.wrapper.GatewayWrapper;

public class GatewayService {	
	
	def servidorService
	
	def get(Long gatewayId){
		Gateway.get(gatewayId);
	}
	
	def loadGateway(Long gatewayId) {
		Gateway g = get(gatewayId);
		if(g){
			this.loadGateway(g);
		}
	}
	def loadGateway(Gateway g) {
		GatewayWrapper gw = GatewayWrapper.toWrapper(g)
		servidorService.getServiceSMS().addGateway(gw);
	}
	
	def unloadGateway(Long gatewayId){
		Gateway g = get(gatewayId)
		if(g){
			this.unloadGateway(g);
		}
	}
	
	def unloadGateway(Gateway g){
		GatewayWrapper gw = GatewayWrapper.toWrapper(g)
		servidorService.getServiceSMS().removeGateway(gw)
	}
	
	def isStartedGatewayServidor(gateway){
		return this.getGatewayServidor(gateway)!=null
	}
	
	def getGatewayServidor(Long gatewayId){
		Gateway g = get(gatewayId)
		if(g){
			this.getGatewayServidor(g)
		}
	}
	
	def getGatewayServidor(Gateway gateway){
		servidorService.getServiceSMS().getGateway(gateway.id.toString())
	}
	
	def getStatusGateway(Long gatewayId){
		Gateway g = get(gatewayId)
		if(g){
			this.getStatusGateway(g)
		}
	}
	
	def getStatusGateway(Gateway gateway){
		GatewayWrapper gw = GatewayWrapper.toWrapper(gateway)
		return gw.getStatusGateway()
	}
		
}
