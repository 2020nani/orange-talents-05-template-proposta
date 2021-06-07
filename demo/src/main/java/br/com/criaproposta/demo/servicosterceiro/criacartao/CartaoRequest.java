package br.com.criaproposta.demo.servicosterceiro.criacartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaForm;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricaoForm;

@FeignClient(url = "http://localhost:8888", name = "AssociaCartaoProposta")
public interface CartaoRequest {
	
	@RequestMapping(value="/api/cartoes", method=RequestMethod.POST, consumes = "application/json")
	CartaoForm criaCartao(StatusRestricaoForm consultaRestricao);

}
