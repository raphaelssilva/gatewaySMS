package biz.r2s.sms.server

import biz.r2s.sms.gateway.Gateway;

class Servidor {
	String url
	Boolean isAtivo	
	static hasMany = [gateway:Gateway]
		
}
