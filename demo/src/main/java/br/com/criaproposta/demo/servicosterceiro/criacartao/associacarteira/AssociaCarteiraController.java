package br.com.criaproposta.demo.servicosterceiro.criacartao.associacarteira;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.criaproposta.demo.exceptions.FieldErrorOutputDto;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusBloqueio;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusCartao;

@RestController
public class AssociaCarteiraController {
	
	@Autowired
	private SistemaAssociaCarteira sistemaassociacarteira;
	
	@Autowired
	private CartaoRepository cartaorepository;
	
	@Autowired
	private AssociaCarteiraRepository carteirarepository;
	
	@PostMapping("cartoes/{idCartao}/carteiras")
	@Transactional
	public ResponseEntity<?> associaCarteiraCartao(@PathVariable("idCartao") String idCartao,
			                                       @RequestBody @Valid AssociaCarteiraForm associacarteiraform,
			                                       UriComponentsBuilder builder) {
		if (idCartao.length() != 19 || idCartao == null ) {
		
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Numero do Cartao precisa ter 19 digitos no formato 0000-0000-0000-0000 ");
		}
		
		Optional<Cartao> cartao = cartaorepository.findById(idCartao);

		if (cartao.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new FieldErrorOutputDto(idCartao,"Nao existe Cartao cadastrado com esse numero "));

		}
		
		if(cartao.get().getStatusCartao().equals(StatusCartao.STATUS_BLOQUEADO)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new FieldErrorOutputDto(idCartao, "Este cartao esta bloqueado, entre em contato com a operadora do cartao "));
		}
		AssociaCarteira carteira = associacarteiraform.getCarteira().carteiradigital(cartao.get(),associacarteiraform, sistemaassociacarteira);
		
		if (carteira == null) {

	           return ResponseEntity.unprocessableEntity().body(new FieldErrorOutputDto("cartao", "Falha ao tentar associar cartao"));

	        }
		
		
		boolean verificaSeCarteiraJaEstaAssocida = cartao.get().associacarteira(carteira);
		
		if(verificaSeCarteiraJaEstaAssocida) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body(new FieldErrorOutputDto(associacarteiraform.getCarteira().name(), "Esta carteira ja esta associada com este cartao "));
		}
		
		carteirarepository.save(carteira);
		
		URI uri = builder.path("carteiras/{id}").buildAndExpand(carteira.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

}
