package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

public class BloqueioForm {
	
	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private boolean ativo;
	
	public BloqueioForm(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo) {
		super();
		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
	}
	
	

}
 