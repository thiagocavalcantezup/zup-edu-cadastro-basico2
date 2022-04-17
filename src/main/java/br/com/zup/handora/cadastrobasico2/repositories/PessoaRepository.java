package br.com.zup.handora.cadastrobasico2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zup.handora.cadastrobasico2.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p FROM Pessoa p JOIN FETCH p.jogos WHERE p.id = :id")
    Optional<Pessoa> findWithJogosById(Long id);

}
