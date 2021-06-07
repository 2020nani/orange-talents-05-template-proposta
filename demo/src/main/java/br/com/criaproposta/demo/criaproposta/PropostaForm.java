package br.com.criaproposta.demo.criaproposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.criaproposta.demo.beansvalidationcriadas.CpfOuCnpj;
import br.com.criaproposta.demo.beansvalidationcriadas.UnicoValor;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.ResultadoRestricao;

public class PropostaForm {

	@NotBlank
	@CpfOuCnpj
	private String documento;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@UnicoValor(domainClass = Proposta.class, fieldName = "email")
	private String email;
	
	@NotBlank
	private String endereco;
	
	@Positive
	private BigDecimal salario;
	
	private EstadoProposta estadoProposta;
	
	public void setEstadoProposta(EstadoProposta estadoProposta) {
		this.estadoProposta = estadoProposta;
	}
	
	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}

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