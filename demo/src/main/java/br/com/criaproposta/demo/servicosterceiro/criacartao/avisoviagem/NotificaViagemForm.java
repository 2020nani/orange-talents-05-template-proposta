package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import java.time.LocalDate;

public class NotificaViagemForm {
	
	private String destino;
	
	private LocalDate validoAte;
	
	private StatusAVisoViagem resultado;
	

	public NotificaViagemForm(String destino, LocalDate validoAte, StatusAVisoViagem resultado) {
		super();
		this.destino = destino;
		this.validoAte = validoAte;
		this.resultado = resultado;
	}


	public StatusAVisoViagem getResultado() {
		return resultado;
	}
	
	

	
	
}
