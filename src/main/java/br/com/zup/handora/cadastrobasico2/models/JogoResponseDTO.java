package br.com.zup.handora.cadastrobasico2.models;

public class JogoResponseDTO {

    private String nome;
    private String descricao;
    private String link;

    public JogoResponseDTO() {}

    public JogoResponseDTO(Jogo jogo) {
        this.nome = jogo.getNome();
        this.descricao = jogo.getDescricao();
        this.link = jogo.getLink();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLink() {
        return link;
    }

}
