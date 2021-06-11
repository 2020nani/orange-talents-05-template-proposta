package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.groups.Default;

import org.springframework.util.Assert;

import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem.AvisoViagem;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.Bloqueio;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusCartao;

@Entity
public class Cartao {

	@Id
	@Column(unique = true)
	private String numeroCartao;
	private LocalDateTime emitidoEm;
	private String titular;
	private int limite;
	@Enumerated(EnumType.STRING)
	private StatusCartao statusCartao = StatusCartao.STATUS_ATIVO;
	private Long idProposta;
	@OneToOne(cascade = CascadeType.MERGE)
	private Renegociacao renegociacao;
	@OneToOne(cascade = CascadeType.MERGE)
	private Vencimento vencimento;
	@OneToOne
	@JoinColumn(name = "proposta_id")
	private Proposta proposta;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cartaoBloqueado",cascade = CascadeType.MERGE)
	private List<Bloqueio> bloqueioCartao;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cartaoReferenteAoAviso",cascade = CascadeType.MERGE)
	private List<AvisoViagem> avisoViagemCartao;

	@Deprecated
	public Cartao() {

	}

	
	
	public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, int limite, StatusCartao statusCartao,
			Long idProposta, Renegociacao renegociacao, Vencimento vencimento, Proposta proposta, List<Bloqueio> bloqueioCartao
			) {
		super();
		this.numeroCartao = numeroCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.statusCartao = statusCartao;
		this.idProposta = idProposta;
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.proposta = proposta;
		this.bloqueioCartao = bloqueioCartao;
	}



	@Override
	public String toString() {
		return "Cartao [numeroCartao=" + numeroCartao + ", emitidoEm=" + emitidoEm + ", titular=" + titular
				+ ", limite=" + limite + ", statusCartao=" + statusCartao + ", idProposta=" + idProposta
				+ ", renegociacao=" + renegociacao + ", vencimento=" + vencimento + ", proposta=" + proposta
				+ ", bloqueioCartaoId=" + bloqueioCartao + "]";
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public int getLimite() {
		return limite;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Proposta getProposta() {
		return proposta;
	}
	
	public StatusCartao getStatusCartao() {
		return statusCartao;
	}
	public List<Bloqueio> getBloqueioCartao() {
		return bloqueioCartao;
	}



	public void bloqueiaCartao(String userAgent, String ipAddress, boolean ativo) {
		Bloqueio bloqueiaCartao = new Bloqueio(userAgent, ipAddress, ativo, this);
		this.statusCartao = StatusCartao.STATUS_BLOQUEADO;
		bloqueioCartao.add(bloqueiaCartao);
		
	}



	public void criaAvisoViagem(AvisoViagem aviso) {
	   Assert.state(aviso!=null,"Nao ha nenhum objeto de aviso de viagem para ser salvo");
	   
	   avisoViagemCartao.add(aviso);
		
	}


	

}
