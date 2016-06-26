package biz.r2s.sms.gateway

import java.util.Date;

import biz.r2s.security.Usuario;

public class Mensagem {
 
	String textoMensagem;
	Date dataCriacao;
	Date dataProcessamento
	Date dataRecebida;	
	
	static belongsTo = [usuario:UsuarioGateway]
	static hasMany = [instancias:InstanciaMensagem]
	 
}
 
