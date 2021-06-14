package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import br.com.criaproposta.demo.exceptions.FieldErrorOutputDto;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusBloqueio;

public enum Carteira {
    paypal {

		@Override
		AssociaCarteira carteiradigital(Cartao cartao, @Valid AssociaCarteiraForm associacarteiraform, SistemaAssociaCarteira sistemaassociacarteira) {
			AssociaCarteira carteira = associacarteiraform.converte(cartao);
			return carteira;
		}
    	
    },
    samsungpay{

		@Override
		AssociaCarteira carteiradigital(Cartao cartao, @Valid AssociaCarteiraForm associacarteiraform, SistemaAssociaCarteira sistemaassociacarteira) {
			AssociaCarteiraForm associacarteira = sistemaassociacarteira.associaCarteiraForm(cartao.getNumeroCartao(),associacarteiraform);
			if (associacarteira.getResultado().equals(StatusSistemaAssociaCarteira.NAO_ASSOCIADA)) {
		           return null;
		        }
			AssociaCarteira carteira = new AssociaCarteira(associacarteiraform.getEmail(), samsungpay, cartao);
			return carteira;
		}
    	
    };

	abstract AssociaCarteira carteiradigital(Cartao cartao, @Valid AssociaCarteiraForm associacarteiraform, SistemaAssociaCarteira sistemaassociacarteira); 
	
}
