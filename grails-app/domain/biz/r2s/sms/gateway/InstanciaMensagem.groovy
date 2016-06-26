package biz.r2s.sms.gateway

import biz.r2s.util.Telefone;

class InstanciaMensagem  {

	Date dataEnvio;
	StatusMensagem statusMensagem;
	String uuid

	static belongsTo = [gateway:Gateway, mensagem:Mensagem, destinatario:Telefone, remetente:Telefone]

	static mapping = { statusMensagem enumType:'string' }
}

