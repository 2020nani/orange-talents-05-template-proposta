package br.com.criaproposta.demo.servicosterceiro.criacartao.associacarteira;

import org.springframework.stereotype.Component;

@Component
public class SistemaAssociaCarteiraFallback implements SistemaAssociaCarteira {

	@Override
	public AssociaCarteiraForm associaCarteiraForm(String idCartao, AssociaCarteiraForm associaCarteiraForm) {
		
		return new AssociaCarteiraForm(null, null, StatusSistemaAssociaCarteira.NAO_ASSOCIADA);
	}

}
