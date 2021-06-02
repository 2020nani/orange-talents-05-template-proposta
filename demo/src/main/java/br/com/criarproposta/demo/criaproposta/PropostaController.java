package br.com.criarproposta.demo.criaproposta;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PropostaController {
	
	@Autowired
	private PropostaRepository propostarepository;
	
	
	@PostMapping("/propostas")
	@Transactional
    public ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaForm propostaform, HttpServletResponse response) {
		Proposta proposta = propostaform.converte();
		if(proposta.jaExisteProposta(propostarepository)) {
		 return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Ja existe proposta cadastrada para este documento " + proposta.getDocumento());
		}
	    propostarepository.save(proposta);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri();
		 return ResponseEntity.created(uri).build();
        
	}
}
