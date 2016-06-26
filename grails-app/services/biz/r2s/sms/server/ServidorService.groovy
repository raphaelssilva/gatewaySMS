package biz.r2s.sms.server

import org.smslib.Library;
import org.smslib.Service;
import org.smslib.Service.ServiceStatus;

import biz.r2s.sms.gateway.Gateway;
import biz.r2s.sms.gateway.InstanciaMensagem;
import biz.r2s.sms.gateway.Mensagem;
import biz.r2s.sms.gateway.notification.InboundNotification;
import biz.r2s.sms.gateway.notification.GatewayStatusNotification
import biz.r2s.sms.gateway.notification.CallNotification
import biz.r2s.sms.gateway.notification.OrphanedMessageNotification
import biz.r2s.sms.gateway.notification.OutboundNotification
import biz.r2s.sms.gateway.wrapper.GatewayWrapper;
import biz.r2s.sms.gateway.wrapper.MensagemEnvioWrapper;
import biz.r2s.sms.server.StatusServidor;

class ServidorService {

	static Service serviceSMS = null
	
	def servidorId = 1

	static Service getServiceSMS(){
		if(!serviceSMS){
			serviceSMS = Service.getInstance()
		}
		return serviceSMS
	}
	
	
	def iniciar() {

		if(this.getServiceSMS().getServiceStatus()==ServiceStatus.STOPPED){
			
			
			this.getServiceSMS().setInboundMessageNotification(new InboundNotification())
			this.getServiceSMS().setGatewayStatusNotification(new GatewayStatusNotification())
			this.getServiceSMS().setCallNotification(new CallNotification())
			this.getServiceSMS().setOrphanedMessageNotification(new OrphanedMessageNotification())
			this.getServiceSMS().setOutboundMessageNotification(new OutboundNotification())
			
			Servidor servidor = Servidor.findById(servidorId)
			
			servidor?.gateway?.each {
				//gatewayService.loadGateway(it)
			}			
			this.getServiceSMS().startService()	
			return true	
		}
		
		return false
	}

	def parar() {
		if(!this.getServiceSMS()&&this.getServiceSMS().getServiceStatus()==ServiceStatus.STARTED){
			this.getServiceSMS().stopService()
		}
	}

	StatusServidor getStatus(){
		ServiceStatus status = this.getServiceSMS().getServiceStatus()
		if(status){
			if(status==ServiceStatus.STARTED)
				return StatusServidor.INICIADO
			else if(status==ServiceStatus.STARTING)
				return StatusServidor.INICIANDO
			else if(status==ServiceStatus.STOPPED)
				return StatusServidor.PARADO
			else if(status==ServiceStatus.STOPPING)
				return StatusServidor.PARANDO
		}
		return null
	}
	
	def getInformacoes(){
		return [
			descricaoAPI:Library.getLibraryDescription(),
			versãoAPI:Library.getLibraryVersion(), 
			JRE:System.getProperty("java.version"),
			JREVM:System.getProperty("java.vm.version"),
			SO:System.getProperty("os.name") + " / " + System.getProperty("os.arch") + " / " + System.getProperty("os.version")		
		]
	}
	
}
