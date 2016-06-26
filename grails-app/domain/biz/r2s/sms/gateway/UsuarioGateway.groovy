package biz.r2s.sms.gateway

import biz.r2s.security.Usuario;

class UsuarioGateway extends Usuario {
 
	static hasMany = [mensagem:Mensagem]
	 
}
 
