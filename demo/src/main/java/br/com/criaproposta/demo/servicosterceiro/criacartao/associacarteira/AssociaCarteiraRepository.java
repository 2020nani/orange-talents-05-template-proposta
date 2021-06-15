package br.com.criaproposta.demo.servicosterceiro.criacartao.associacarteira;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociaCarteiraRepository extends JpaRepository<AssociaCarteira, Long> {

	boolean existsByCarteira(Carteira carteira);

}
