package br.com.criaproposta.demo.metodosget;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem.AvisoViagem;

public class AvisoViagemDto {

	private Long id;
    private String destino;
    private String ipCliente;
    private String userAgent;
    private LocalDate validoAte;
    private LocalDate horadatarequisicao;
    
    

	public AvisoViagemDto(Long id, String destino, String ipCliente, String userAgent, LocalDate validoAte,
			LocalDate horadatarequisicao) {
		super();
		this.id = id;
		this.destino = destino;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.validoAte = validoAte;
		this.horadatarequisicao = horadatarequisicao;
	}



	public static List<AvisoViagemDto> converte(List<AvisoViagem> avisoViagemCartao) {
		List<AvisoViagemDto> avisos = new ArrayList<AvisoViagemDto>();
		avisoViagemCartao.forEach(aviso -> {
			AvisoViagemDto objeto = new AvisoViagemDto(aviso.getId(), aviso.getDestino(),aviso.getIpCliente(),aviso.getUserAgent(),
					             aviso.getValidoAte(), aviso.getHoradatarequisicao());
			avisos.add(objeto);
		});
		return avisos;
	}



	public Long getId() {
		return id;
	}



	public String getDestino() {
		return destino;
	}



	public String getIpCliente() {
		return ipCliente;
	}



	public String getUserAgent() {
		return userAgent;
	}



	public LocalDate getValidoAte() {
		return validoAte;
	}



	public LocalDate getHoradatarequisicao() {
		return horadatarequisicao;
	}

	
}
