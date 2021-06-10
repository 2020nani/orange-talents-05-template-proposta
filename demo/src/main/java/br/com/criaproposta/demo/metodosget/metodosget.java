package br.com.criaproposta.demo.metodosget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.criaproposta.demo.cadastrabiometria.Biometria;
import br.com.criaproposta.demo.cadastrabiometria.BiometriaRepository;
import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaRepository;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

@RestController
public class metodosget {
	
	@Autowired
	private CartaoRepository cartaorepository;
	
	@Autowired
	private PropostaRepository propostarepository;
	
	@Autowired
	private BiometriaRepository biometriarepository;
	
	@GetMapping("/teste/{id}")
	public Proposta listaPropostas(@PathVariable("id") Long id){
		Proposta propostas = propostarepository.findById(id).get();
		return propostas;
		
	}
	@GetMapping("/teste/cartoes/{id}")
	public Cartao listaCartoes(@PathVariable("id") Long id){
		Cartao cartoes = cartaorepository.findById("id").get();
		return cartoes;
		
	}
	@GetMapping("/teste/biometrias/{id}")
	public Biometria listaBiometrias(@PathVariable("id") Long id){
		Biometria biometrias = biometriarepository.findById(id).get();
		return biometrias;
		
	}

}
