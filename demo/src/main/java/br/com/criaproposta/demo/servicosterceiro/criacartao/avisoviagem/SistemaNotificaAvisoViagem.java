package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.NotificaBloqueioForm;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.SistemaNotificaBloqueioCartaoFallback;

@FeignClient(url = "http://${proposta.services.sistemaCartao.host}:${proposta.services.sistemaCartao.port}",
name = "NotificaAvisoViagem", fallback = SistemaNotificaAvisoViagemFallback.class)
public interface SistemaNotificaAvisoViagem {

@RequestMapping(method = RequestMethod.POST, path = "/api/cartoes/{idCartao}/avisos")
NotificaViagemForm notificaViagemForm( NotificaViagemForm notificaViagemForm, @PathVariable String idCartao);

}