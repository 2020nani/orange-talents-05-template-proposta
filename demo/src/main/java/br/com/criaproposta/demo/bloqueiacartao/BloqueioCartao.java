package br.com.criaproposta.demo.bloqueiacartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

@Entity
public class BloqueioCartao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String userAgent;
	
	@NotBlank
	private String ipCliente;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "cartao_id")
	private Cartao cartaoBloqueado;
	
	@CreationTimestamp
	private LocalDateTime instanteBloqueio;

	@Deprecated
	public BloqueioCartao() {
		// TODO Auto-generated constructor stub
	}
	public BloqueioCartao(String userAgent, String ipCliente, Cartao cartao) {
		super();
		this.userAgent = userAgent;
		this.ipCliente = ipCliente;
		this.cartaoBloqueado = cartao;
		
	}
	
	

	public Long getId() {
		return id;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public Cartao getCartaoBloqueado() {
		return cartaoBloqueado;
	}
	public LocalDateTime getInstanteBloqueio() {
		return instanteBloqueio;
	}
	@Override
	public String toString() {
		return "BloqueioCartao [userAgent=" + userAgent + ", ipCliente=" + ipCliente + ", cartao=" + cartaoBloqueado
				+ ", instanteBloqueio=" + instanteBloqueio + "]";
	}
	
	
	

}
