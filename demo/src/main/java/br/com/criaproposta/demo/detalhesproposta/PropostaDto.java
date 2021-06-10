package br.com.criaproposta.demo.detalhesproposta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.criaproposta.demo.beansvalidationcriadas.CpfOuCnpj;
import br.com.criaproposta.demo.bloqueiacartao.BloqueioCartao;
import br.com.criaproposta.demo.bloqueiacartao.StatusCartao;
import br.com.criaproposta.demo.criaproposta.EstadoProposta;
import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Renegociacao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Vencimento;

public class PropostaDto {

	private Long idProposta;

	private String documento;

	private String nome;

	private String email;

	private String endereco;

	private BigDecimal salario;

	private EstadoProposta estadoProposta;

	private String numeroCartao;
	private LocalDateTime dataemissaocartao;
	private String titularCartao;
	private int limiteCartao;
	private Renegociacao renegociacao;
	private Vencimento vencimento;
	private StatusCartao statusCartao;
	private Long idBloqueio;
	private String ipCliente;
	private String userAgent;
	private LocalDateTime dataBloqueio;

	public PropostaDto(Proposta proposta, Cartao cartao) {
		if(proposta.getCartao() != null && proposta.getCartao().getBloqueioCartaoId() != null) {
		this.idProposta = proposta.getId();
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.email = proposta.getEmail();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.estadoProposta = proposta.getEstadoProposta();
		this.numeroCartao = proposta.getCartao().getNumeroCartao();
		this.dataemissaocartao = proposta.getCartao().getEmitidoEm();
		this.titularCartao = proposta.getCartao().getTitular();
		this.limiteCartao = proposta.getCartao().getLimite();
		this.renegociacao = proposta.getCartao().getRenegociacao();
		this.vencimento = proposta.getCartao().getVencimento();
		this.statusCartao = proposta.getCartao().getStatusCartao();
		this.idBloqueio = proposta.getCartao().getBloqueioCartaoId().getId();
		this.ipCliente = proposta.getCartao().getBloqueioCartaoId().getIpCliente();
		this.userAgent = proposta.getCartao().getBloqueioCartaoId().getUserAgent();
		this.dataBloqueio = proposta.getCartao().getBloqueioCartaoId().getInstanteBloqueio();
		
		}
		
		if(proposta.getCartao() != null && proposta.getCartao().getBloqueioCartaoId() == null) {
			this.idProposta = proposta.getId();
			this.documento = proposta.getDocumento();
			this.nome = proposta.getNome();
			this.email = proposta.getEmail();
			this.endereco = proposta.getEndereco();
			this.salario = proposta.getSalario();
			this.estadoProposta = proposta.getEstadoProposta();
			this.numeroCartao = proposta.getCartao().getNumeroCartao();
			this.dataemissaocartao = proposta.getCartao().getEmitidoEm();
			this.titularCartao = proposta.getCartao().getTitular();
			this.limiteCartao = proposta.getCartao().getLimite();
			this.renegociacao = proposta.getCartao().getRenegociacao();
			this.vencimento = proposta.getCartao().getVencimento();
			this.statusCartao = proposta.getCartao().getStatusCartao();
			
			}
		
		if(proposta.getCartao() == null ) {
			this.idProposta = proposta.getId();
			this.documento = proposta.getDocumento();
			this.nome = proposta.getNome();
			this.email = proposta.getEmail();
			this.endereco = proposta.getEndereco();
			this.salario = proposta.getSalario();
			this.estadoProposta = proposta.getEstadoProposta();
			
			
			}
		
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public EstadoProposta getEstadoProposta() {
		return estadoProposta;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public LocalDateTime getDataemissaocartao() {
		return dataemissaocartao;
	}

	public String getTitularCartao() {
		return titularCartao;
	}

	public int getLimiteCartao() {
		return limiteCartao;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public StatusCartao getStatusCartao() {
		return statusCartao;
	}

	public Long getIdBloqueio() {
		return idBloqueio;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public LocalDateTime getDataBloqueio() {
		return dataBloqueio;
	}
	

}
