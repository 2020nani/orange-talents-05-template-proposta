package br.com.criaproposta.demo.servicosterceiro.criacartao.avisoviagem;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.criaproposta.demo.servicosterceiro.criacartao.Cartao;

public class AvisoViagemForm {
	
	    @NotBlank
	    private String destino;
	    
	    @FutureOrPresent
	    @NotNull
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	    private LocalDate validoAte;

		public AvisoViagemForm(@NotBlank String destino,@FutureOrPresent @NotNull LocalDate validoAte) {
			super();
			this.destino = destino;
			this.validoAte = validoAte;
			
		}

		public AvisoViagem converte(String ipAddress, String userAgent, Cartao cartao) {
			// TODO Auto-generated method stub
			return new AvisoViagem(destino, ipAddress, userAgent, validoAte,cartao);
		}

		
	    
	    
	  

}
