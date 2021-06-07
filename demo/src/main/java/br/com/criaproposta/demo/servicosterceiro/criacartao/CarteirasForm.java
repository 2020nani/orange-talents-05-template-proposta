package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

public class CarteirasForm {
	
	private String id;
	private String email;
	private LocalDateTime associadaEm;
	private String emissor;
	
	public CarteirasForm(String id, String email, LocalDateTime associadaEm, String emissor) {
		super();
		this.id = id;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
	}
	
	

}
