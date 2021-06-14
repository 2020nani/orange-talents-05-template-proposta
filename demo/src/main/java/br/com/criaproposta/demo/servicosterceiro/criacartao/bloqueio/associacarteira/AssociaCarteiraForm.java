package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;


public class AssociaCarteiraForm {
	
	@Email
	@NotBlank
	private String email;
	
	@NotNull
	private Carteira carteira;
	
	private StatusSistemaAssociaCarteira resultado;

	public AssociaCarteiraForm(@Email @NotBlank String email, @NotNull Carteira carteira,
			StatusSistemaAssociaCarteira resultado) {
		super();
		this.email = email;
		this.carteira = carteira;
		this.resultado = resultado;
	}

	public AssociaCarteira converte(Cartao cartao) {
		// TODO Auto-generated method stub
		return new AssociaCarteira(email, carteira, cartao) ;
	}
	
	public Carteira getCarteira() {
		return carteira;
	}

	public String getEmail() {
		return email;
	}

	public StatusSistemaAssociaCarteira getResultado() {
		return resultado;
	}

	
}
