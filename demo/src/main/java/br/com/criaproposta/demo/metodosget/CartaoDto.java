package br.com.criaproposta.demo.metodosget;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.criaproposta.demo.criaproposta.Proposta;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Renegociacao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Vencimento;
import br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem.AvisoViagem;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.Bloqueio;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.StatusCartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira.AssociaCarteira;
import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira.Carteira;

public class CartaoDto {

	private String numeroCartao;
	private LocalDateTime emitidoEm;
	private String titular;
	private int limite;
	private StatusCartao statusCartao = StatusCartao.STATUS_ATIVO;
	private Long idProposta;
	private String idVencimento;
	private int diaVencimento;
	private LocalDateTime dataDeCriacaoVencimento;
	private List<BloqueioDto> bloqueio;
	private List<AvisoViagemDto> aviso;
	private List<AssociaCarteiraDto> associacarteira;
	

	public CartaoDto(String numeroCartao, LocalDateTime emitidoEm, String titular, int limite,
			StatusCartao statusCartao, Long idProposta, String idVencimento, int diaVencimento,
			LocalDateTime dataDeCriacaoVencimento, List<BloqueioDto> bloqueio, List<AvisoViagemDto> aviso,
			List<AssociaCarteiraDto> associacarteira) {
		super();
		this.numeroCartao = numeroCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.statusCartao = statusCartao;
		this.idProposta = idProposta;
		this.idVencimento = idVencimento;
		this.diaVencimento = diaVencimento;
		this.dataDeCriacaoVencimento = dataDeCriacaoVencimento;
		this.bloqueio = bloqueio;
		this.aviso = aviso;
		this.associacarteira = associacarteira;
	}




	public static List<CartaoDto> converte(List<Cartao> cartoes) {
		List<CartaoDto> retorno = new ArrayList<CartaoDto>();
		cartoes.forEach(cartao -> {
			CartaoDto objeto = new CartaoDto(cartao.getNumeroCartao(), cartao.getEmitidoEm(), cartao.getTitular(),
			           cartao.getLimite(), cartao.getStatusCartao(), cartao.getIdProposta(), cartao.getVencimento().getId(),
			           cartao.getVencimento().getDia(),cartao.getVencimento().getDataDeCriacao(),BloqueioDto.converte(cartao.getBloqueioCartao()),
			           AvisoViagemDto.converte(cartao.getAvisoViagemCartao()), AssociaCarteiraDto.converte(cartao.getCarteiraassociada()));
			retorno.add(objeto);
		});
		return retorno;
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

	public StatusCartao getStatusCartao() {
		return statusCartao;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public String getIdVencimento() {
		return idVencimento;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public LocalDateTime getDataDeCriacaoVencimento() {
		return dataDeCriacaoVencimento;
	}

	public List<BloqueioDto> getBloqueio() {
		return bloqueio;
	}
	public List<AvisoViagemDto> getAviso() {
		return aviso;
	}

	public List<AssociaCarteiraDto> getAssociacarteira() {
		return associacarteira;
	}
	
	
	

}
