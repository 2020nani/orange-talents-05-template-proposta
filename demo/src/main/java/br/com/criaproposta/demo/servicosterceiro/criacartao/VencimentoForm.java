package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

public class VencimentoForm {

	private String id;
	private int dia;
	private LocalDateTime dataDeCriacao;
	
	public VencimentoForm(String id, int dia, LocalDateTime dataDeCriacao) {
		super();
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}
	
	public Vencimento converte() {
        return new Vencimento(id, dia, dataDeCriacao);
    }
	
	
}
