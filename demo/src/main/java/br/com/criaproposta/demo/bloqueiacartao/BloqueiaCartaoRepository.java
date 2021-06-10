package br.com.criaproposta.demo.bloqueiacartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueiaCartaoRepository extends JpaRepository<BloqueioCartao, Long> {

}
