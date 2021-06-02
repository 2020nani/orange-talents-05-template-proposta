package br.com.criarproposta.demo.criaproposta;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.criarproposta.demo.beansvalidationcriadas.CpfOuCnpj;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@CpfOuCnpj
	private String documento;

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String endereco;

	@Positive
	private BigDecimal salario;
	
	@Deprecated
	public Proposta() {
		// TODO Auto-generated constructor stub
	}

	public Proposta(@NotBlank @CpfOuCnpj String documento, @NotBlank String nome, @NotBlank @Email String email,
			@NotBlank String endereco, @Positive BigDecimal salario) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}
	
	public String getDocumento() {
		return documento;
	}

	public Long getId() {
		return id;
	}

	public boolean jaExisteProposta(PropostaRepository propostarepository) {
		Optional<Proposta> proposta = propostarepository.findByDocumento(documento);
		if(proposta.isPresent()) {
		    return true;	
		}
		return false;
	}


}
