package br.com.criaproposta.demo.cadastrabiometria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometriaRepository extends JpaRepository<Biometria, Long> {

}
