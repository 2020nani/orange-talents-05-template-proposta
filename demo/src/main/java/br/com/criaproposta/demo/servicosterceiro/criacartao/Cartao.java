package br.com.criaproposta.demo.servicosterceiro.criacartao;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.groups.Default;

import br.com.criaproposta.demo.criaproposta.Proposta;

@Entity
public class Cartao {
	
	    @Id 
	    @Column(unique = true)
	    private String numeroCartao;
	    private LocalDateTime emitidoEm;
        private String titular;
        private int limite;
        private Long idProposta;
        @OneToOne(cascade = CascadeType.MERGE)    
        private Renegociacao renegociacao;
        @OneToOne(cascade = CascadeType.MERGE)    
        private Vencimento vencimento;
	    @OneToOne @JoinColumn(name = "proposta_id")
	    private Proposta proposta;
		
	    @Deprecated
		public Cartao() {
	
		}
		
		public Cartao(String numeroCartao, LocalDateTime emitidoEm, String titular, int limite, Long idProposta,
				Renegociacao renegociacao, Vencimento vencimento, Proposta proposta) {
			super();
			this.numeroCartao = numeroCartao;
			this.emitidoEm = emitidoEm;
			this.titular = titular;
			this.limite = limite;
			this.idProposta = idProposta;
			this.renegociacao = renegociacao;
			this.vencimento = vencimento;
			this.proposta = proposta;
		}


		
		@Override
		public String toString() {
			return "Cartao [numeroCartao=" + numeroCartao + ", emitidoEm=" + emitidoEm + ", titular=" + titular
					+ ", limite=" + limite + ", idProposta=" + idProposta + ", vencimento=" + vencimento + ", proposta="
					+ proposta + "]";
		}

		public String getNumeroCartao() {
			return numeroCartao;
		}
		public Proposta getProposta() {
			return proposta;
		}
		
	   

}
