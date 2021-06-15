package br.com.criaproposta.demo.servicosterceiro.criacartao.associacarteira;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(url = "http://${proposta.services.sistemaCartao.host}:${proposta.services.sistemaCartao.port}",
name = "AssociaCarteira", fallback = SistemaAssociaCarteiraFallback.class)
public interface SistemaAssociaCarteira {
	
	@RequestMapping(method = RequestMethod.POST, path = "/api/cartoes/{idCartao}/carteiras")
	AssociaCarteiraForm associaCarteiraForm(@PathVariable("idCartao") String idCartao, AssociaCarteiraForm associaCarteiraForm);

}
