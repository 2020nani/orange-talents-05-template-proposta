package br.com.criaproposta.demo.servicosterceiro;

import br.com.criaproposta.demo.criaproposta.Proposta;

public class StatusAvaliacaoForm {

	private String documento;
	private String nome;
	private ResultadoAvaliacao resultadoSolicitacao;
	private Long idProposta;

	public StatusAvaliacaoForm(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId();
	}
	
	@Deprecated
	public StatusAvaliacaoForm() {
		super();
	}



	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public ResultadoAvaliacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	@Override
	public String toString() {
		return "StatusAvaliacaoForm [documento=" + documento + ", nome=" + nome + ", resultadoSolicitacao="
				+ resultadoSolicitacao + ", idProposta=" + idProposta + "]";
	}
	
	

}
