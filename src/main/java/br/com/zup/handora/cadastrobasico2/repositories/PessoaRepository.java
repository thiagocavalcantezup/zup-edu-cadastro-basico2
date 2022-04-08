package br.com.zup.handora.cadastrobasico2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.cadastrobasico2.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
