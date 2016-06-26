package biz.r2s.util

public class Pessoa{

	String nome	
	String sobrenome
	String email
	
	static hasMany = [telefones:Telefone, enderecos:Endereco]
	
}
