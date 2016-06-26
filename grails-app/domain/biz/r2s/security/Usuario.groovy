package biz.r2s.security 

import biz.r2s.util.PessoaFisica

class Usuario extends PessoaFisica {
	String login
	String senha
	String token
	String perguntaSecreta
	String respostaSecreta
	Boolean isAtivo
	
	static hasMany = [sessoes: Sessao]
}

