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

	public AssociaCarteiraForm(@Email String email, @NotBlank Carteira carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}

	public AssociaCarteira converte(Cartao cartao) {
		// TODO Auto-generated method stub
		return new AssociaCarteira(email, carteira, cartao) ;
	}
	
	public Carteira getCarteira() {
		return carteira;
	}

}
