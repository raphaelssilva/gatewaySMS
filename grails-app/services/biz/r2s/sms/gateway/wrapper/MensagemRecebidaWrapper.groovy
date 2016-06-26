package biz.r2s.sms.gateway.wrapper

import org.smslib.InboundMessage;

import biz.r2s.sms.gateway.Gateway;
import biz.r2s.sms.gateway.InstanciaMensagem;
import biz.r2s.sms.gateway.StatusMensagem;
import biz.r2s.sms.gateway.Mensagem;
import biz.r2s.util.Telefone

class MensagemRecebidaWrapper extends InboundMessage{
	Mensagem fromWrapper(){
		Mensagem mensagem = Mensagem.findById(this.id.toLong())
				
		if(!mensagem){
			mensagem = new Mensagem()
			mensagem.setDataRecebida(this.getDate())
			mensagem.setTextoMensagem(this.getText())
						
			InstanciaMensagem instancia = new InstanciaMensagem()
			instancia.gateway = Gateway.get(this.gatewayId)
			instancia.remetente = Telefone.convertTelefone(this.originator)
			instancia.statusMensagem = this.getStatus()		
		}		
		return mensagem
	}
	
	static MensagemRecebidaWrapper toWrapper(Mensagem mensagem){
		MensagemRecebidaWrapper mRecebida = new MensagemRecebidaWrapper()		
		mRecebida.setId(mensagem.id.toString())	
	}
	
	StatusMensagem getStatus(){
		return StatusMensagem.RECEBIDA
	}
	
}
