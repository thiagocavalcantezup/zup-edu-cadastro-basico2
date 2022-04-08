package br.com.zup.handora.cadastrobasico2.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "pessoa_jogo", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "jogo_id"))
    Set<Jogo> jogos = new HashSet<>();

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Pessoa() {}

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void adicionar(Set<Jogo> novosJogos) {
        this.jogos.addAll(novosJogos);
        novosJogos.forEach(novoJogo -> novoJogo.getJogadores().add(this));
    }

    public Long getId() {
        return id;
    }

}
