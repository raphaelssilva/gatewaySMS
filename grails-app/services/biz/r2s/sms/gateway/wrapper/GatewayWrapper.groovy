package biz.r2s.sms.gateway.wrapper

import org.smslib.modem.SerialModemGateway;
import org.smslib.AGateway.GatewayStatuses;

import biz.r2s.sms.gateway.Gateway;
import biz.r2s.sms.gateway.StatusGateway;
import biz.r2s.sms.server.ServidorService

import biz.r2s.util.Telefone

class GatewayWrapper extends SerialModemGateway{

	public GatewayWrapper(gatewayid, porta, velocidade, marca, modelo){
		super(gatewayid, porta, velocidade, marca, modelo)
	}

	Gateway fromWrapper(){

		if(this.gatewayId){
			Gateway gateway =  Gateway.findById(this.gatewayId.toLong());
			if(!gateway){
				gateway = new Gateway();
				gateway.porta = this.modemDevice
				gateway.velocidade = this.modemParms
				gateway.marca = this.manufacturer
				gateway.modelo = this.model
				gateway.pin = this.simPin
				gateway.temCaixaEntrada = this.outbound
				gateway.temCaixaSaida = this.inbound
				gateway.from = Telefone.convertTelefone(this.smscNumber)
			}

			gateway.sinalOperadora = this.getSignalLevel()
			gateway.serialModem = this.getSerialNo()
			gateway.cargaBateria = this.getBatteryLevel()
			gateway.simImsi = this.getImsi()

			return gateway
		}

		return null
	}

	static GatewayWrapper toWrapper(Gateway g){
		GatewayWrapper gatewayWrapper = ServidorService.getServiceSMS().getGateway(g.id.toString())
		if(gatewayWrapper){
			gatewayWrapper = new GatewayWrapper(g.id.toString(), g.porta, g.velocidade, g.marca, g.modelo)
			gatewayWrapper.setInbound(g.temCaixaEntrada);
			gatewayWrapper.setOutbound(g.temCaixaSaida);
			gatewayWrapper.setSimPin(g.pin);
			gatewayWrapper.setSmscNumber(g.from.toString());
		}
		return gatewayWrapper
	}

	public StatusGateway getStatusGateway(){
		switch (super.getStatus()){
			case GatewayStatuses.STOPPED:
				return StatusGateway.PARADO
				break;
			case GatewayStatuses.STOPPING:
				return StatusGateway.PARANDO
				break;
			case GatewayStatuses.STARTING:
				return StatusGateway.INICIANDO
				break
			case GatewayStatuses.STARTED:
				return StatusGateway.INICIADO
				break
			case GatewayStatuses.FAILURE:
				return StatusGateway.FALHA
				break
			case GatewayStatuses.RESTART:
				return StatusGateway.RESTARTANDO
				break
		}
	}
}
