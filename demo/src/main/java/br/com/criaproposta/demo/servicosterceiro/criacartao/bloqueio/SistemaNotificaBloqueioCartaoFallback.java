package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio;

import org.springframework.stereotype.Component;

@Component
public class SistemaNotificaBloqueioCartaoFallback implements SistemaNotificaBloqueioCartao {

	@Override
	public NotificaBloqueioForm notificaBloqueioDoCartao(NotificaBloqueioForm notificaBloqueioForm, String idCartao) {
		
		return new NotificaBloqueioForm(StatusBloqueio.FALHA,null);
	}

}
