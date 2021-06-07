package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vencimento {

	@Id
	private String id;
	private int dia;
	private LocalDateTime dataDeCriacao;
	
	@Deprecated
	public Vencimento() {
		// TODO Auto-generated constructor stub
	}
	
	public Vencimento(String id, int dia, LocalDateTime dataDeCriacao) {
		super();
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
	}

	@Override
	public String toString() {
		return "Vencimento [id=" + id + ", dia=" + dia + ", dataDeCriacao=" + dataDeCriacao + "]";
	}
	
	
}
