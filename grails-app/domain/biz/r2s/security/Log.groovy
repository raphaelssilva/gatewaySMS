package biz.r2s.security
class Log {
	Date data;
	Nivel nivel;
	int prioridade;
	String mensagem;
	TipoLog tipoLog;

	static mapping = {
		tipoLog enumType:'string'
		nivel enumType:'string'
	}
}