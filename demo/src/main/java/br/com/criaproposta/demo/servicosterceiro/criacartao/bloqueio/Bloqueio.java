package br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

@Entity
public class Bloqueio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String userAgent;
	
	@NotBlank
	private String ipCliente;
	
	private boolean ativo;
	
	@NotNull
	@Valid
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartao_id")
	private Cartao cartaoBloqueado;
	
	@CreationTimestamp
	private LocalDateTime instanteBloqueio;

	@Deprecated
	public Bloqueio() {
		// TODO Auto-generated constructor stub
	}

	public Bloqueio(@NotBlank String userAgent, @NotBlank String ipCliente, boolean ativo,
			@NotNull Cartao cartaoBloqueado) {
		super();
		this.userAgent = userAgent;
		this.ipCliente = ipCliente;
		this.ativo = ativo;
		this.cartaoBloqueado = cartaoBloqueado;
	}

	@Override
	public String toString() {
		return "Bloqueio [id=" + id + ", userAgent=" + userAgent + ", ipCliente=" + ipCliente + ", ativo=" + ativo
				+ ", cartaoBloqueado=" + cartaoBloqueado + ", instanteBloqueio=" + instanteBloqueio + "]";
	}

	
	
	
}
