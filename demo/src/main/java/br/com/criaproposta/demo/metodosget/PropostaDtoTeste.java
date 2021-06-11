package br.com.criaproposta.demo.metodosget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.criaproposta.demo.beansvalidationcriadas.CpfOuCnpj;
import br.com.criaproposta.demo.criaproposta.EstadoProposta;
import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

public class PropostaDtoTeste {

	private Long id;
	private String documento;

	private String nome;

	private String email;

	private String endereco;

	private BigDecimal salario;

	private EstadoProposta estadoProposta;


	public PropostaDtoTeste(Long id, String documento, String nome, String email, String endereco, BigDecimal salario,
			EstadoProposta estadoProposta) {
		super();
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
		this.estadoProposta = estadoProposta;
	
	}

	public static List<PropostaDtoTeste> converte(List<Proposta> propostas) {
		List<PropostaDtoTeste> retorno = new ArrayList<PropostaDtoTeste>();
		propostas.forEach(proposta -> {
			PropostaDtoTeste objeto = new PropostaDtoTeste(proposta.getId(), proposta.getDocumento(),
					proposta.getNome(), proposta.getEmail(), proposta.getEndereco(), proposta.getSalario(),
					proposta.getEstadoProposta());
			retorno.add(objeto);
		});
		return retorno;
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}



}
