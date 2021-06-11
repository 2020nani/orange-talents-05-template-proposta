package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criaproposta.demo.exceptions.FieldErrorOutputDto;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

@RestController
public class BloqueioCartaoController {
	
	private final Logger logger = LoggerFactory.getLogger(BloqueioCartaoController.class);
	
	@Autowired
	private SistemaNotificaBloqueioCartao sistemabloqueio;
	
	@Autowired
	private CartaoRepository cartaorepository;

	@PostMapping("cartoes/{idCartao}/bloqueios")
	@Transactional
	public ResponseEntity<?> bloqueiaCartao(@PathVariable("idCartao") String idCartao, 
			                                HttpServletRequest request) throws BindException  {

		logger.info("metodo iniciou");
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
		
		if(cartao.get().getStatusCartao().equals(StatusCartao.STATUS_BLOQUEADO)) {
			BindException problemaBloqueioCartao = new BindException(cartao, "cartao");
			problemaBloqueioCartao.reject(null,"Cartao ja esta bloqueado");

			throw problemaBloqueioCartao;
		}
		
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String userAgent = request.getHeader("User-Agent");
		
		NotificaBloqueioForm statusAvisoViagem = sistemabloqueio.notificaBloqueioDoCartao(new NotificaBloqueioForm(null, userAgent),idCartao);
		
		if (statusAvisoViagem.getResultado().equals(StatusBloqueio.FALHA)) {

	           return ResponseEntity.unprocessableEntity().body(new FieldErrorOutputDto("cartao", "Cartão falhou ao ser bloqueado"));

	        }
		
		cartao.get().bloqueiaCartao(userAgent, ipAddress, true);
	
		cartaorepository.save(cartao.get());
		
		logger.info("metodo finalizado com sucesso cartao numero " +idCartao.substring(0,4)+ "-****-****-" +idCartao.substring(15)+ " bloqueado" );
		return ResponseEntity.ok().build();
	}

}
