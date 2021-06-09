package br.com.criaproposta.demo.metodosget;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/propostas")
	public List<Proposta> listaPropostas(){
		List<Proposta> propostas = propostarepository.findAll();
		return propostas;
		
	}
	@GetMapping("/cartoes")
	public List<Cartao> listaCartoes(){
		List<Cartao> cartoes = cartaorepository.findAll();
		return cartoes;
		
	}
	@GetMapping("/biometrias")
	public List<Biometria> listaBiometrias(){
		List<Biometria> biometrias = biometriarepository.findAll();
		return biometrias;
		
	}

}
