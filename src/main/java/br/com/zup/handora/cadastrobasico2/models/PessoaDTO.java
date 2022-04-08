package br.com.zup.handora.cadastrobasico2.models;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

    public String getNome() {
        return nome;
    }

    public Set<Long> getJogos() {
        return jogoIds;
    }

}
