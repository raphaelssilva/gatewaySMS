package biz.r2s.util
class Telefone{
	String numero
	String descricao
	Integer ddd
	Integer ramal
	Integer codPais
	
	static belongsTo = [pessoa:Pessoa]
	
	static Telefone convertTelefone(String telefoneStr){
		Telefone telefone = new Telefone();

		telefone.codPais = telefoneStr.replaceAll("+",'').substring(0,2)
		telefone.ddd = telefoneStr.replaceAll("+",'').substring(2,4)
		telefone.numero = telefoneStr.replaceAll("+",'').substring(4)
		
		return telefone

	}
	
	@Override
	public String toString() {
		return "+"+this.codPais+this.ddd+this.numero;
	}
}

