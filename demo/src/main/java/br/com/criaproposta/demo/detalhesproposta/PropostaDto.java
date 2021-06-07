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
	

	public PropostaDto(Proposta proposta, Cartao cartao) {
		if(cartao != null) {
		this.idProposta = cartao.getProposta().getId();
		this.documento = cartao.getProposta().getDocumento();
		this.nome = cartao.getProposta().getNome();
		this.email = cartao.getProposta().getEmail();
		this.endereco = cartao.getProposta().getEndereco();
		this.salario = cartao.getProposta().getSalario();
		this.estadoProposta = cartao.getProposta().getEstadoProposta();
		this.numeroCartao = cartao.getNumeroCartao();
		this.dataemissaocartao = cartao.getEmitidoEm();
		this.titularCartao = cartao.getTitular();
		this.limiteCartao = cartao.getLimite();
		this.renegociacao = cartao.getRenegociacao();
		this.vencimento = cartao.getVencimento();
		}
		this.idProposta = proposta.getId();
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.email = proposta.getEmail();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.estadoProposta = proposta.getEstadoProposta();
		 
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




}
