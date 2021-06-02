package br.com.criarproposta.demo.criaproposta;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criarproposta.demo.beansvalidationcriadas.CpfOuCnpj;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	Optional<Proposta> findByDocumento(@NotBlank @CpfOuCnpj String documento);

}
