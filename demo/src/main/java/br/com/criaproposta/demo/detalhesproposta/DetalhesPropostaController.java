package br.com.criaproposta.demo.detalhesproposta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaRepository;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

@RestController
public class DetalhesPropostaController {
	
	@Autowired
	private PropostaRepository propostarepository;
	
	@Autowired
	private CartaoRepository cartaorepository;

	@GetMapping("/detalheproposta/{idProposta}")
	public ResponseEntity<?> detalheProposta(@PathVariable("idProposta") Long idProposta) throws BindException {
		boolean existeObjetoProposta = propostarepository.existsById(idProposta);
		if(existeObjetoProposta) {
		
		Proposta proposta = propostarepository.findById(idProposta).get();
		
		Cartao cartao = cartaorepository.findByPropostaId(idProposta);
		
		PropostaDto detalheProposta = new PropostaDto(proposta,cartao);
		
		return ResponseEntity.ok().body(detalheProposta);
		}
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao existe proposta com o id passado na requisicao");
		
	}

}
