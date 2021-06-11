package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.validation.groups.Default;

import br.com.criaproposta.demo.beansvalidationcriadas.ExisteObjeto;
import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.criaproposta.PropostaRepository;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.Bloqueio;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusCartao;

public class CartaoForm {
    @ExisteObjeto(domainClass = Cartao.class, fieldName = "numeroCartao")
	private String numeroCartao;
	
	private LocalDateTime emitidoEm;
	
	private String titular;
	
	private int limite;
	
	private List<Bloqueio> bloqueioCartao;
	
	private RenegociacaoForm renegociacao;
	
	private VencimentoForm vencimento;
	
	private Long idProposta;


	public CartaoForm(String id, LocalDateTime emitidoEm, String titular, 
			int limite, RenegociacaoForm renegociacao, VencimentoForm vencimento, Long idProposta, List<Bloqueio> bloqueioCartao) {
		super();
		this.numeroCartao = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.bloqueioCartao = bloqueioCartao;
		this.limite = limite;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.idProposta = idProposta;
		
	}
     

	public Cartao converte(PropostaRepository propostarepository) {
		Proposta proposta = propostarepository.findById(idProposta).get();
		return new Cartao(numeroCartao, emitidoEm, titular, limite, StatusCartao.STATUS_ATIVO, idProposta, renegociacao != null ? renegociacao.converte() : null , vencimento.converte(), proposta,bloqueioCartao);
				
	}

	

}
