package biz.r2s.sms.gateway

import org.smslib.InboundMessage.MessageClasses;

import biz.r2s.sms.gateway.wrapper.MensagemEnvioWrapper;
import biz.r2s.sms.gateway.wrapper.MensagemRecebidaWrapper;

class MensagemService {

	def servidorService
	def gatewayService
	
	def enviarMensagem(Mensagem mensagem, boolean fila = true){
		List mensagensToSend = mensagem?.instancias.collect{ MensagemEnvioWrapper.toWrapper(it)}
		if(mensagensToSend){
			if(fila){
				servidorService.getServiceSMS().queueMessages(mensagensToSend)
			}
			else{
				servidorService.getServiceSMS().sendMessages(mensagensToSend)
			}
		}
	}
	
	def enviarMensagem(Mensagem mensagem, Gateway g, boolean fila = true){
		List mensagensToSend = mensagem?.instancias.collect{ MensagemEnvioWrapper.toWrapper(it)}
		if(mensagensToSend){
			if(fila){
				servidorService.getServiceSMS().queueMessages(mensagensToSend, g.id.toString())
			}
			else{
				servidorService.getServiceSMS().sendMessages(mensagensToSend, g.id.toString())
			}
		}
	}
	
	def lerMensagens(){
		def mensagens = servidorService.getServiceSMS().readMessages(MessageClasses.ALL)		
		return mensagens?.collect({(it as MensagemRecebidaWrapper).fromWrapper()})		
	}
	
	def lerMensagems(Long gatewayId){
		Gateway gateway = gatewayService.get(gatewayId)
		if(gateway){
			return this.lerMensagems(gateway)
		}
		return null	
	}	
	
	def lerMensagems(Gateway g){
		def gateway = gatewayService.getGatewayServidor(g.id.toString())
		def mensagens = servidorService.getServiceSMS().readMessages(MessageClasses.ALL, gateway)
		return mensagens?.collect({(it as MensagemRecebidaWrapper).fromWrapper()})
	}
	
	def deletarMensagem(Mensagem m){
	
		
	}
	
	def deletarMensagem(InstanciaMensagem im){
	
		
	}
	
	def deletarMensagem(long imId){
	
		
	}
	
	def deletarMensagens(Gateway g){
	
		
	}
	
	def deletarMensagens(long gid){
	
		
	}
	
}
