package br.com.criaproposta.demo.servicosterceiro.criacartao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criaproposta.demo.servicosterceiro.criacartao.bloqueio.associacarteira.Carteira;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {

	Cartao findByPropostaId(Long idProposta);

	Cartao findByNumeroCartao(String idCartao);


}
