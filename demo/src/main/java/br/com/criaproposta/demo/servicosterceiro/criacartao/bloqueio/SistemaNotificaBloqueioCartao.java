package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://${proposta.services.sistemaCartao.host}:${proposta.services.sistemaCartao.port}",
             name = "NotificaBloqueioCartao", fallback = SistemaNotificaBloqueioCartaoFallback.class)
public interface SistemaNotificaBloqueioCartao {
	
	@RequestMapping(method = RequestMethod.POST, path = "/api/cartoes/{idCartao}/bloqueios")
    NotificaBloqueioForm notificaBloqueioDoCartao( NotificaBloqueioForm notificaBloqueioForm, @PathVariable String idCartao);

}
