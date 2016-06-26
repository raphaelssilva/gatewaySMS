package biz.r2s.security

class Sessao {
	Date inicioAcesso
	Date fimAcesso
	String ip
	String cookie
	Boolean isAtivo
	
	static belongsTo = [usuario: Usuario]
	
	static hasMany = [logAcessos:LogAcesso]
}
