package br.com.zup.handora.cadastrobasico2.models;

import javax.validation.constraints.NotBlank;

public class JogoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String link;

    public JogoDTO() {}

    public JogoDTO(@NotBlank String nome, @NotBlank String descricao, @NotBlank String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
    }

    public Jogo paraJogo() {
        return new Jogo(nome, descricao, link);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
