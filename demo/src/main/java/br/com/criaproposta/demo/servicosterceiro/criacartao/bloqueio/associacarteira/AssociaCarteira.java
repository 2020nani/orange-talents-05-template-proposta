package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

@Entity
public class AssociaCarteira {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotBlank
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Carteira carteira;
	
	@NotNull
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartao_id")
	private Cartao cartaoAssociado;
	
	@Deprecated
	public AssociaCarteira() {
		// TODO Auto-generated constructor stub
	}

	public AssociaCarteira(@Email String email, @NotBlank Carteira carteira,
			@NotNull @Valid Cartao cartaoAssociado) {
		super();
		this.email = email;
		this.carteira = carteira;
		this.cartaoAssociado = cartaoAssociado;
	}
	
	public Carteira getCarteira() {
		return carteira;
	}
	
	public Long getId() {
		return id;
	}

	
	public String getEmail() {
		return email;
	}

	public Cartao getCartaoAssociado() {
		return cartaoAssociado;
	}

	@Override
	public String toString() {
		return "AssociaCarteira [id=" + id + ", email=" + email + ", carteira=" + carteira + "]";
	}
	

}
