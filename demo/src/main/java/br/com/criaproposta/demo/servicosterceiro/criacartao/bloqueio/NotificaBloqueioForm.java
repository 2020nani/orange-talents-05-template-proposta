package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio;

public class NotificaBloqueioForm {

	private StatusBloqueio resultado;

	private String sistemaResponsavel;

	

	public NotificaBloqueioForm(StatusBloqueio resultado, String sistemaResponsavel) {
		super();
		this.resultado = resultado;
		this.sistemaResponsavel = sistemaResponsavel;
	}

	public StatusBloqueio getResultado() {
		return resultado;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	@Override
	public String toString() {
		return "NotificaBloqueioForm [resultado=" + resultado + ", sistemaResponsavel=" + sistemaResponsavel + "]";
	}

}
