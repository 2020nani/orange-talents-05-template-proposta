package br.com.criaproposta.demo.metodosget;

import java.util.ArrayList;
import java.util.Collection;
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
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;

@RestController
public class metodosget {
	
	@Autowired
	private MeterRegistry meterRegistry;
	
	@Autowired
	private CartaoRepository cartaorepository;
	
	@Autowired
	private PropostaRepository propostarepository;
	
	@Autowired
	private BiometriaRepository biometriarepository;
	
	public void criarGauge(List<PropostaDtoTeste> proposta) {

        this.meterRegistry.gauge("meu_gauge", proposta.size());
    }
	
	 @Autowired
	 public void metricasTimer() {
	        Collection<Tag> tags = new ArrayList<>();
	        
	        Timer timerConsultarProposta = this.meterRegistry.timer("consultar_proposta", tags);
	        timerConsultarProposta.record(() -> {
	            listaPropostas();
	            
	        });
	        
	    }
	
	@GetMapping("/teste")
	public List<PropostaDtoTeste> listaPropostas(){
		List<Proposta> propostas = propostarepository.findAll();
		List<PropostaDtoTeste> propostaslistadas = PropostaDtoTeste.converte(propostas);
		criarGauge(propostaslistadas);
		return propostaslistadas;
		
	}
	@GetMapping("/teste/cartoes")
	public List<CartaoDto> listaCartoes(){
		List<Cartao> cartoes = cartaorepository.findAll();
		List<CartaoDto> listaCartoes = CartaoDto.converte(cartoes);
		return listaCartoes;
		
	}
	@GetMapping("/teste/biometrias/{id}")
	public Biometria listaBiometrias(@PathVariable("id") Long id){
		Biometria biometrias = biometriarepository.findById(id).get();
		return biometrias;
		
	}

}
