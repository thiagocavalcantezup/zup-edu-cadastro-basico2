package br.com.zup.handora.cadastrobasico2.models;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.handora.cadastrobasico2.repositories.JogoRepository;

public class PessoaDTO {

    @NotBlank
    private String nome;

    @Valid
    Set<Long> jogoIds;

    public PessoaDTO() {}

    public PessoaDTO(@NotBlank String nome, Set<Long> jogoIds) {
        this.nome = nome;
        this.jogoIds = jogoIds;
    }

    public Pessoa toModel(JogoRepository jogoRepository) {
        Pessoa pessoa = new Pessoa(nome);
        Set<Jogo> novosJogos = jogoIds.stream()
                                      .map(
                                          id -> jogoRepository.findById(id)
                                                              .orElseThrow(
                                                                  () -> new ResponseStatusException(
                                                                      HttpStatus.NOT_FOUND,
                                                                      "Não existe um jogo com o ID informado."
                                                                  )
                                                              )
                                      )
                                      .collect(Collectors.toSet());
        pessoa.adicionar(novosJogos);

        return pessoa;

    }

    public String getNome() {
        return nome;
    }

    public Set<Long> getJogos() {
        return jogoIds;
    }

}
