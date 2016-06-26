package biz.r2s.sms.gateway

import biz.r2s.sms.server.Servidor;
import biz.r2s.util.Telefone;

class Gateway{

	String nome;
	String porta;
	String velocidade;
	String marca;
	String modelo;
	int pin;
	boolean temCaixaEntrada;
	boolean temCaixaSaida;

	//transients
	String sinalOperadora
	String serialModem
	String cargaBateria
	String simImsi

	static belongsTo = [servidor:Servidor, from:Telefone]

	static hasMany = [instanciaMensagemEnvio:InstanciaMensagem]

	static transients = [
		'sinalOperadora',
		'serialModem',
		'cargaBateria',
		'simImsi'
	]
	
	
}

