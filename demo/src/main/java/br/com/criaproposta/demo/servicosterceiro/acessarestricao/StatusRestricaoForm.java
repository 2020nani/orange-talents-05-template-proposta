package br.com.criaproposta.demo.servicosterceiro.acessarestricao;

import br.com.criaproposta.demo.criaproposta.Proposta;

public class StatusRestricaoForm {

	private String documento;
	private String nome;
	private ResultadoRestricao resultadoSolicitacao;
	private Long idProposta;

	public StatusRestricaoForm(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getId();
	}
	
	@Deprecated
	public StatusRestricaoForm() {
		super();
	}



	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public ResultadoRestricao getResultadoSolicitacao() {
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
