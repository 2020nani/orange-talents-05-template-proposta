package br.com.criaproposta.demo.criaproposta;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.criaproposta.demo.exceptions.FieldErrorOutputDto;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.ResultadoRestricao;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricao;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricaoForm;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.opentracing.Span;
import io.opentracing.Tracer;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class PropostaController {

	@Autowired
	private MeterRegistry meterRegistry;

	@Autowired
	private StatusRestricao statusAvaliacao;

	@Autowired
	private PropostaRepository propostarepository;

	private Counter contadorPropostasSalvas;

	@PostConstruct
	public void metricasCounter() {
		Collection<Tag> tags = new ArrayList<>();
		this.contadorPropostasSalvas = this.meterRegistry.counter("proposta_criada_com_sucesso", tags);
	}

	@PostMapping("/propostas")
	@Transactional
	public ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaForm propostaform, UriComponentsBuilder builder) {

		Proposta proposta = propostaform.converte();

		if (proposta.jaExisteProposta(propostarepository)) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Ja existe proposta cadastrada para este documento " + proposta.getDocumento());
		}

		propostarepository.save(proposta);

		StatusRestricaoForm statusRestricao = statusAvaliacao.buscaStatusAvaliacao(new StatusRestricaoForm(proposta));

		if (statusRestricao.getResultadoSolicitacao().equals(ResultadoRestricao.COM_RESTRICAO)) {

			return ResponseEntity.unprocessableEntity()
					.body(new FieldErrorOutputDto("documento", "Documento possui restricao no sistema"));

		}

		proposta.atualizaRestricaoProposta(statusRestricao.getResultadoSolicitacao());

		if (proposta.getId() != null) {
			contadorPropostasSalvas.increment();
		}
		
		URI uri = builder.path("proposta/{id}").buildAndExpand(proposta.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
}
