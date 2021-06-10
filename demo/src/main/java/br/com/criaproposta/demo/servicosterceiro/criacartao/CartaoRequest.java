package br.com.criaproposta.demo.servicosterceiro.criacartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaForm;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricaoForm;

@FeignClient(url = "http://${proposta.services.sistemaCartao.host}:${proposta.services.sistemaCartao.port}", name = "AssociaCartaoProposta")
public interface CartaoRequest {
	
	//@RequestMapping(value="/api/cartoes", method=RequestMethod.POST, consumes = "application/json")
	@RequestMapping(method = RequestMethod.GET, path = "/api/cartoes?idProposta={idProposta}")
	CartaoForm criaCartao(@PathVariable("idProposta") Long idProposta);

}
