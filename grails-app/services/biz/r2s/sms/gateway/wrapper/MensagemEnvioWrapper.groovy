package biz.r2s.sms.gateway.wrapper

import biz.r2s.sms.gateway.InstanciaMensagem;
import biz.r2s.sms.gateway.StatusMensagem;
import biz.r2s.sms.gateway.Mensagem
import org.smslib.OutboundMessage
import org.smslib.OutboundMessage.FailureCauses
import org.smslib.OutboundMessage.MessageStatuses


class MensagemEnvioWrapper extends OutboundMessage{

	InstanciaMensagem fromWrapper(){
		InstanciaMensagem instanciaMensagem = InstanciaMensagem.findById(this.id)
		instanciaMensagem.setStatusMensagem(this.getStatus())
		instanciaMensagem.save(flush:true)
		return instanciaMensagem
	}

	static MensagemEnvioWrapper toWrapper(InstanciaMensagem instancia){

		MensagemEnvioWrapper mensagem = new MensagemEnvioWrapper()
		mensagem.setId(instancia.id.toString())
		mensagem.setDate(instancia.mensagem.dataProcessamento)
		mensagem.setText(instancia.mensagem.textoMensagem)
		mensagem.setRecipient(instancia.destinatario.toString())
		if(instancia.gateway){
			mensagem.setFrom(instancia.gateway.from.toString())
			mensagem.setGatewayId(instancia.gateway.id.toString())
		}
	}

	public StatusMensagem getStatus(){

		if(this.getMessageStatus()!=MessageStatuses.FAILED){
			switch (this.getMessageStatus()) {
				case MessageStatuses.SENT:
					return StatusMensagem.ENVIADA
					break;
				case MessageStatuses.UNSENT:
					return StatusMensagem.ENVIANDO
					break;
			}
		}else{
			switch (this.getFailureCause()) {
				case FailureCauses.BAD_NUMBER:
					return StatusMensagem.NUMERO_INVALIDO
					break;
				case FailureCauses.BAD_FORMAT:
					return StatusMensagem.MENSAGEM_INVALIDA
					break;
				case FailureCauses.GATEWAY_FAILURE:
					return StatusMensagem.FALHA_NO_GATEWAY
					break;
				case FailureCauses.NO_CREDIT:
					return StatusMensagem.SEM_CREDITO
					break;
				case FailureCauses.GATEWAY_AUTH:
					return StatusMensagem.FALHA_AUTH_GATEWAY
					break;
				case FailureCauses.NO_ROUTE:
					return StatusMensagem.NAO_ROTEADA
					break;
				case FailureCauses.UNKNOWN:
					return StatusMensagem.ERRO_DESCONHECIDO
					break;
			}
		}
		
		return StatusMensagem.PROCESSANDO
	}
}
