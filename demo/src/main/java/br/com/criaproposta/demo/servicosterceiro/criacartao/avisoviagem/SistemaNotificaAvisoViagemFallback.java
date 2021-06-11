package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import org.springframework.stereotype.Component;


@Component
public class SistemaNotificaAvisoViagemFallback implements SistemaNotificaAvisoViagem{

	@Override
	public NotificaViagemForm notificaViagemForm(NotificaViagemForm notificaViagemForm, String idCartao) {
		// TODO Auto-generated method stub
		return new NotificaViagemForm(null, null, StatusAVisoViagem.FALHA);
	}


}
