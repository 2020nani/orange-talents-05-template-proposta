package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

public class RenegociacaoForm {

	private String id;
	private int quantidade;
	private int valor;
	private LocalDateTime dataDeCriacao;
	
	public RenegociacaoForm(String id, int quantidade, int valor, LocalDateTime dataDeCriacao) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}
	
	public Renegociacao converte() {
        return new Renegociacao(id, quantidade, valor, dataDeCriacao);
    }
	
	
}
