package biz.r2s.sms.gateway

public enum StatusMensagem {
	PROCESSANDO,
	ENVIANDO,
	ENVIADA,
	CANCELADA,
	RECEBIDA,
	NAO_RECEBIDA,
	NUMERO_INVALIDO,
	MENSAGEM_INVALIDA,
	FALHA_NO_GATEWAY,
	FALHA_AUTH_GATEWAY,
	SEM_CREDITO,
	NAO_ROTEADA,
	ERRO_DESCONHECIDO;
}