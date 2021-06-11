package br.com.criaproposta.demo.servicosterceiro.acessarestricao;

import org.springframework.stereotype.Component;

@Component
public class StatusRestricaoFallback implements StatusRestricao {

	@Override
	public StatusRestricaoForm buscaStatusAvaliacao(StatusRestricaoForm statusAvaliacaoForm) {
		
		return new StatusRestricaoForm(ResultadoRestricao.COM_RESTRICAO, null);
	}

}
