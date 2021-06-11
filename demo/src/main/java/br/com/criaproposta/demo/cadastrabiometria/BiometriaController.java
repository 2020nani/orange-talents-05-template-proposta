package br.com.criaproposta.demo.cadastrabiometria;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

@RestController
public class BiometriaController {
	
	private final Logger logger = LoggerFactory.getLogger(BiometriaController.class);
	
	@Autowired
	private CartaoRepository cartaorepository;
	
	@Autowired
	private BiometriaRepository biometriarepository;
	
	@PostMapping("/cartao/{idCartao}/biometria")
	public ResponseEntity<?> cadastraBiometria(@PathVariable("idCartao") String idCartao, @RequestBody 
			                               @Valid BiometriaForm biometriaform, UriComponentsBuilder builder) {
		logger.info("metodo iniciou");
		
		if (!cartaorepository.existsById(idCartao)) {
			logger.info("Nao existe objeto");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Nao existe Cartao cadastrado com esse numero " + idCartao);
			
		}
		
		Cartao cartao = cartaorepository.findByNumeroCartao(idCartao);
		
		Biometria biometria = biometriaform.converte(cartao);
		
		biometriarepository.save(biometria);
		
		URI uri = builder.path("biometria/{id}").buildAndExpand(biometria.getId()).toUri();
		
		logger.info("Biometria criada" + biometria.getId());
		logger.warn("Log de aviso, algo está errado ou faltando! cuidado!");
        logger.error("Log de erro, algo de errado aconteceu!");
        logger.debug("Log de depuração, contém informações mais refinadas, que são mais úteis para depurar um aplicativo");
        logger.trace("Log de rastreabilidade, contém informações mais refinadas do que o DEBUG");

		return ResponseEntity.created(uri).build();
		
		
	}
	
	

}
