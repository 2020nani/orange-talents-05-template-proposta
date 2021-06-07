package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Renegociacao {

	@Id
	private String id;
	private int quantidade;
	private int valor;
	private LocalDateTime dataDeCriacao;
	
	@Deprecated
	public Renegociacao() {
		// TODO Auto-generated constructor stub
	}

	public Renegociacao(String id, int quantidade, int valor, LocalDateTime dataDeCriacao) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
	}

	@Override
	public String toString() {
		return "Renegociacao [id=" + id + ", quantidade=" + quantidade + ", valor=" + valor + ", dataDeCriacao="
				+ dataDeCriacao + "]";
	}
	
	
}
