package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.criaproposta.demo.criaproposta.EstadoProposta;
import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaRepository;
import br.com.criaproposta.demo.servicosterceiro.acessarestricao.StatusRestricaoForm;




@Component
@EnableScheduling
public class AssociaCartaoProposta {
	    @Autowired
	    private CartaoRequest cartaorequest;
	    
	    @Autowired
	    private CartaoRepository cartaorepository; 
	    
	    @Autowired
	    private PropostaRepository propostarepository;
	    
	    
	    private Logger logger = LoggerFactory.getLogger(AssociaCartaoProposta.class);
	
	@Scheduled(fixedRate=5000)
    public void associar(){
        logger.info("O agendamento foi iniciado");
        List<Proposta> propostas = propostarepository.findByEstadoPropostaAndCartaoIsNull(EstadoProposta.ELEGIVEL);
        if(propostas.size() <= 0) {
            logger.info("Nao ha propostas para atualzar");
            return; 
        } 

        propostas.forEach(proposta -> {
            StatusRestricaoForm consultaRestricao = new StatusRestricaoForm(proposta);
            CartaoForm cartaoform = cartaorequest.criaCartao(consultaRestricao);
            
            Cartao cartao = cartaoform.converte(propostarepository);
    
            cartaorepository.save(cartao);
    
            logger.info("Cartao numero: " + cartao.getNumeroCartao().substring(0,3)
            		+ "****" + "****"  
            		+ cartao.getNumeroCartao().substring(cartao.getNumeroCartao().length()-4, 19) 
            		+", Proposta de Id: " + cartao.getProposta().getId() + " Cadastrado com Sucesso!!" );
        });





        logger.info("Concluido o metodo");

    }

}
