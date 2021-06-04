package br.com.criaproposta.demo.servicosterceiro;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:9999", name = "BuscaStatusAvaliacao")
public interface StatusRestricao {
	
	@RequestMapping(value="/api/solicitacao", method=RequestMethod.POST, consumes = "application/json")
	StatusRestricaoForm buscaStatusAvaliacao(StatusRestricaoForm statusAvaliacaoForm);

}
