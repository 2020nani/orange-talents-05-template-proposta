package br.com.criaproposta.demo.metodosget;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.Bloqueio;

public class BloqueioDto {

	private Long id;
	private String userAgent;
	private String ipCliente;
	private boolean ativo;
	private LocalDateTime instanteBloqueio;
	public BloqueioDto(Long id, String userAgent, String ipCliente, boolean ativo, LocalDateTime instanteBloqueio) {
		super();
		this.id = id;
		this.userAgent = userAgent;
		this.ipCliente = ipCliente;
		this.ativo = ativo;
		this.instanteBloqueio = instanteBloqueio;
	}
	public static List<BloqueioDto> converte(List<Bloqueio> bloqueioCartao) {
		List<BloqueioDto> bloqueio = new ArrayList<BloqueioDto>();
		bloqueioCartao.forEach(blo -> {
			BloqueioDto objeto = new BloqueioDto(blo.getId(), blo.getUserAgent(), blo.getIpCliente(),
					             blo.isAtivo(), blo.getInstanteBloqueio());
			bloqueio.add(objeto);
		});
		return bloqueio;
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
	public boolean isAtivo() {
		return ativo;
	}
	public LocalDateTime getInstanteBloqueio() {
		return instanteBloqueio;
	}
	
	
}
