package br.com.criaproposta.demo.criaproposta;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.criaproposta.demo.beansvalidationcriadas.CpfOuCnpj;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.ResultadoRestricao;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricaoForm;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

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
	
	@Enumerated(EnumType.STRING)
    private EstadoProposta estadoProposta;
	
	@OneToOne(mappedBy = "proposta")
    private Cartao cartao;
	
	@Deprecated
	public Proposta() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Proposta(EstadoProposta estadoProposta) {
		super();
		this.estadoProposta = estadoProposta;
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


	public Cartao getCartao() {
		return cartao;
	}


	public boolean jaExisteProposta(PropostaRepository propostarepository) {
		Optional<Proposta> proposta = propostarepository.findByDocumento(documento);
		if(proposta.isPresent()) {
		    return true;	
		}
		return false;
	}

	public void atualizaRestricaoProposta(ResultadoRestricao resultadoAvaliacao) {
		if(resultadoAvaliacao.equals(ResultadoRestricao.SEM_RESTRICAO)) {
			this.estadoProposta = EstadoProposta.ELEGIVEL;
		}else {
			this.estadoProposta = EstadoProposta.NAO_ELEGIVEL;
		}
		
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", documento=" + documento + ", nome=" + nome + ", email=" + email + ", endereco="
				+ endereco + ", salario=" + salario + ", estadoProposta=" + estadoProposta + "]";
	}



	
}