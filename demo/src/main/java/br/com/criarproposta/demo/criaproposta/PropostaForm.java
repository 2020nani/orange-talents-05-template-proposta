package br.com.criarproposta.demo.criaproposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



import br.com.criarproposta.demo.beansvalidationcriadas.CpfOuCnpj;


public class PropostaForm {

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

	public PropostaForm(@NotBlank String documento, @NotBlank String nome, @NotBlank @Email String email,
			@NotBlank String endereco, @Positive @NotNull @NotEmpty BigDecimal salario) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta converte() {
		
		return new Proposta(documento, nome, email, endereco, salario);
	}


	
}
