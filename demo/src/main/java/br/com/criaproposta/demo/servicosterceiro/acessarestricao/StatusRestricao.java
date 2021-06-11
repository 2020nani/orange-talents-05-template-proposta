package br.com.criaproposta.demo.servicosterceiro.acessarestricao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.SistemaNotificaBloqueioCartaoFallback;

@FeignClient(url = "http://${proposta.services.analiseFinanceira.host}:${proposta.services.analiseFinanceira.port}",
                    name = "BuscaStatusAvaliacao", fallback = StatusRestricaoFallback.class)
public interface StatusRestricao {
	
	@RequestMapping(value="/api/solicitacao", method=RequestMethod.POST, consumes = "application/json")
	StatusRestricaoForm buscaStatusAvaliacao(StatusRestricaoForm statusAvaliacaoForm);

}
