package biz.r2s.sms.gateway

class MensagemController {
	
	def mensagemService
	
	def enviarMensagem(Long mensagemId){
		Mensagem mensagem = Mensagem.get(mensagemId);
		if(mensagem){
			mensagemService.enviarMensagem(mensagem)
		}
	}
	
	
	def enviarMensagemGateway(Long mensagemId, Long gatewayId){
		Mensagem mensagem = Mensagem.get(mensagemId);
		Gateway g = Gateway.get(gatewayId);
		if(mensagem&&g){
			mensagemService.enviarMensagem(mensagem, g)
		}
	}
	
	def lerMensagens(){
		
	}
	
	def lerMensagemsGateway(Long gatewayId){
		
	}
	
	def deletarMensagem(long imId){
		
	}
	
	def deletarMensagens(){
		
	}
	
	def deletarMensagensGateway(Long gatewayId){
		
	}
	
	def cancelarEnvioMensagem(long mensagemId){
		
	}
	
	def cancelarEnvioMensagens(){
		
	}

	def cancelarEnvioMensagensGateway(Long gatewayId){
		
	}
	
	def getStatusMensagem(long mensagemId){
		
	}
	
	def getStatusMensagens(){
		
	}
	
	def getStatusMensagensGateway(Long gatewayId){
		
	}
	
	def getStatusInstanciaMensagem(long imId){
		
	}
	
	def getStatusInstanciasMensagens(){
	
	}
	
	def getStatusInstanciasMensagensGateway(Long gatewayId){
	
	}
	
	def getCountMensagens(){
		
	}
	
	def getCountMensagensGateway(){
	
	}
}
