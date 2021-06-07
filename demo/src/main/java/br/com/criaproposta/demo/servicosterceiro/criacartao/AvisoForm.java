package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

public class AvisoForm {
	
	private LocalDateTime validoAte;
	private String destino;
	
	public AvisoForm(LocalDateTime validoAte, String destino) {
		super();
		this.validoAte = validoAte;
		this.destino = destino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((validoAte == null) ? 0 : validoAte.hashCode());
		return result;
	}


}
