package br.com.zup.handora.cadastrobasico2.models;

import java.util.Set;
import java.util.stream.Collectors;

public class PessoaResponseDTO {

    private String nome;
    private Set<JogoResponseDTO> jogos;

    public PessoaResponseDTO() {}

    public PessoaResponseDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.jogos = pessoa.getJogos()
                           .stream()
                           .map(JogoResponseDTO::new)
                           .collect(Collectors.toSet());
    }

    public String getNome() {
        return nome;
    }

    public Set<JogoResponseDTO> getJogos() {
        return jogos;
    }

}
