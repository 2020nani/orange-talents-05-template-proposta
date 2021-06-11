package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.criaproposta.demo.exceptions.FieldErrorOutputDto;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.BloqueioCartaoController;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusCartao;

@RestController
public class AvisoViagemController {

	private final Logger logger = LoggerFactory.getLogger(AvisoViagemController.class);

	@Autowired
	private CartaoRepository cartaorepository;

	@PostMapping("cartoes/{idCartao}/aviso")
	public ResponseEntity<?> cadastraAvisoViagem(@PathVariable("idCartao") String idCartao, HttpServletRequest request,
			@RequestBody @Valid AvisoViagemForm avisoviagemform) {
		if (idCartao.length() != 19 || idCartao == null) {
			logger.info("Nao passou id na url ");
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Numero do Cartao precisa ter 19 digitos no formato 0000-0000-0000-0000 ");

		}
		Optional<Cartao> cartao = cartaorepository.findById(idCartao);

		if (cartao.isEmpty()) {

			logger.info("Nao existe objeto");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Nao existe Cartao cadastrado com esse numero " + idCartao);

		}
		
		if (cartao.get().getStatusCartao().equals(StatusCartao.STATUS_BLOQUEADO)) {
			
			logger.info("Tentou avisar viagem e cartao esta bloqueado");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new FieldErrorOutputDto(idCartao, "Este cartao esta bloqueado, entre em contato com a operadora do cartao "));
			
		}
		

		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String userAgent = request.getHeader("User-Agent");

		AvisoViagem aviso = avisoviagemform.converte(ipAddress, userAgent,cartao.get());
		
		cartao.get().criaAvisoViagem(aviso);

		cartaorepository.save(cartao.get());

		return ResponseEntity.ok().build();
	}

}
