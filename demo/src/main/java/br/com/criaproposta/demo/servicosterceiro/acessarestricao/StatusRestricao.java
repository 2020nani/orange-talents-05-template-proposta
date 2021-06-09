package br.com.criaproposta.demo.servicosterceiro.acessarestricao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://${proposta.services.analiseFinanceira.host}:${proposta.services.analiseFinanceira.port}", name = "BuscaStatusAvaliacao")
public interface StatusRestricao {
	
	@RequestMapping(value="/api/solicitacao", method=RequestMethod.POST, consumes = "application/json")
	StatusRestricaoForm buscaStatusAvaliacao(StatusRestricaoForm statusAvaliacaoForm);

}
