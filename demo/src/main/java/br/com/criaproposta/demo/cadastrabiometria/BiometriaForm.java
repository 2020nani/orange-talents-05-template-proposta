package br.com.criaproposta.demo.cadastrabiometria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.criaproposta.demo.beansvalidationcriadas.ConfirmaBase64;
import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;
import br.com.criaproposta.demo.servicosterceiro.criacartao.CartaoRepository;

public class BiometriaForm {
	
	@NotBlank
	@ConfirmaBase64
	private String fingerprint;

	@JsonCreator
	public BiometriaForm(@NotBlank String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
	public String getFingerprint() {
		return fingerprint;
	}

	public Biometria converte(Cartao cartao) {
		
		return new Biometria(fingerprint, cartao);
	}

}
