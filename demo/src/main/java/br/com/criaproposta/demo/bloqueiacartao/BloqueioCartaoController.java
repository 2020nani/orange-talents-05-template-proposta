package br.com.criaproposta.demo.bloqueiacartao;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.criaproposta.demo.cadastrabiometria.BiometriaController;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

@RestController
public class BloqueioCartaoController {
	
	private final Logger logger = LoggerFactory.getLogger(BloqueioCartaoController.class);
	
	@Autowired
	private CartaoRepository cartaorepository;
	
	@Autowired
	private BloqueiaCartaoRepository bloqueiacartaorepository;

	@PostMapping("cartao/{idCartao}/bloqueia")
	public ResponseEntity<?> bloqueiaCartao(@PathVariable("idCartao") String idCartao, 
			                                HttpServletRequest request) throws BindException  {

		logger.info("metodo iniciou");
		if (idCartao.length() != 19 || idCartao == null) {
			logger.info("Nao passou id na url ");
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Numero do Cartao precisa ter 19 digitos no formato 0000-0000-0000-0000 ");

		}

		if (!cartaorepository.existsById(idCartao)) {
			
			logger.info("Nao existe objeto");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Nao existe Cartao cadastrado com esse numero " + idCartao);

		}
		
		Cartao cartao = cartaorepository.findById(idCartao).get();
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String userAgent = request.getHeader("User-Agent");
		boolean bloqueio = cartao.bloqueiaCartao();
		if(!bloqueio) {
			BindException problemaBloqueioCartao = new BindException(bloqueio, "bloqueio");
			problemaBloqueioCartao.reject(null,"Cartao ja esta bloqueado");

			throw problemaBloqueioCartao;
		}
		BloqueioCartao bloqueioCartao = new BloqueioCartao(userAgent, ipAddress, cartao);
		
		bloqueiacartaorepository.save(bloqueioCartao);
		
		logger.info("metodo finalizado com sucesso cartao numero " +idCartao.substring(0,4)+ "-****-****-" +idCartao.substring(15)+ " bloqueado" );
		return ResponseEntity.ok().build();
	}

}

