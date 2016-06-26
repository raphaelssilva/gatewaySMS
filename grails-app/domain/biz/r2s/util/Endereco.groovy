package biz.r2s.util
class Endereco{
	Integer numero
	String complemento
	String rua
	String bairro
	String cidade
	String estado
	String pais
	String CEP

	static belongsTo = [pessoa:Pessoa]
}

