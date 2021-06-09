package br.com.criaproposta.demo.cadastrabiometria;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Length(max = 500)
	private String fingerprint;
	
	@CreationTimestamp
	private LocalDateTime dataCadastro;

	@NotNull
	@ManyToOne
	private Cartao cartaoAssociado;

	@Deprecated
	public Biometria() {
		// TODO Auto-generated constructor stub
	}
	
	public Biometria(@NotBlank String fingerprint, Cartao cartaoAssociado) {
		super();
		this.fingerprint = fingerprint;
		this.cartaoAssociado = cartaoAssociado;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public Cartao getCartaoAssociado() {
		return cartaoAssociado;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Biometria [id=" + id + ", fingerprint=" + fingerprint + ", dataCadastro=" + dataCadastro
				+ ", cartaoAssociado=" + cartaoAssociado + "]";
	}
	

}
