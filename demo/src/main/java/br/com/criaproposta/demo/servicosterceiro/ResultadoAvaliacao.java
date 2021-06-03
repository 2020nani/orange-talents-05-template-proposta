package br.com.criaproposta.demo.servicosterceiro;

import br.com.criaproposta.demo.criaproposta.EstadoProposta;
import br.com.criaproposta.demo.criaproposta.Proposta;

public enum ResultadoAvaliacao {
	COM_RESTRICAO {
		@Override
		Proposta adicionaStatusProposta() {
			return new Proposta(EstadoProposta.NAO_ELEGIVEL);
			
		}
		
	},
	SEM_RESTRICAO {
		@Override
		Proposta adicionaStatusProposta() {
			return new Proposta(EstadoProposta.ELEGIVEL);
			
		}
		
	};
	abstract Proposta adicionaStatusProposta();
	
}
