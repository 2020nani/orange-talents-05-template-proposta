package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

@Entity
public class AvisoViagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
    private String destino;
    
    @NotBlank
    private String ipCliente;
    
    @NotBlank
    private String userAgent;
    
    @FutureOrPresent
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validoAte;
    
    @NotNull
    @Valid
    @ManyToOne(fetch = FetchType.LAZY)
    private Cartao cartaoReferenteAoAviso;
	    
    @CreationTimestamp
    private LocalDate horadatarequisicao;

    @Deprecated
    public AvisoViagem() {
		// TODO Auto-generated constructor stub
	}

	public AvisoViagem(@NotBlank String destino, @NotBlank String ipCliente, @NotBlank String userAgent,
			@FutureOrPresent @NotNull LocalDate validoAte, @NotNull @Valid Cartao cartaoReferenteAoAviso) {
		super();
		this.destino = destino;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.validoAte = validoAte;
		this.cartaoReferenteAoAviso = cartaoReferenteAoAviso;
	}


	@Override
	public String toString() {
		return "AvisoViagem [id=" + id + ", destino=" + destino + ", ipCliente=" + ipCliente + ", userAgent="
				+ userAgent + ", validoAte=" + validoAte + ", horadatarequisicao=" + horadatarequisicao + "]";
	}

	
}
