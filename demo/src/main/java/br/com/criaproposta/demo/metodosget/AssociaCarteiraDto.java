package br.com.criaproposta.demo.metodosget;

import java.util.ArrayList;
import java.util.List;

import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira.AssociaCarteira;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira.Carteira;

public class AssociaCarteiraDto {

	private Long id;
	private String email;
	private Carteira carteira;

	public AssociaCarteiraDto(Long id, String email, Carteira carteira) {
		super();
		this.id = id;
		this.email = email;
		this.carteira = carteira;
	}



	public static List<AssociaCarteiraDto> converte(List<AssociaCarteira> carteiraassociada) {
		List<AssociaCarteiraDto> carteiras = new ArrayList<AssociaCarteiraDto>();
		carteiraassociada.forEach(cart -> {
			AssociaCarteiraDto carteira = new AssociaCarteiraDto(cart.getId(), cart.getEmail(), cart.getCarteira());
			carteiras.add(carteira);
		});
		return carteiras;
	}



	public Long getId() {
		return id;
	}



	public String getEmail() {
		return email;
	}



	public Carteira getCarteira() {
		return carteira;
	}
	
	

}
