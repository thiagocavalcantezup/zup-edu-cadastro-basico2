package br.com.zup.handora.cadastrobasico2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogo {

    /*
     * https://docs.jboss.org/hibernate/orm/5.3/userguide/html_single/Hibernate_User_Guide.html
     *
     * 2.5.5. Providing identifier attribute(s)
     *
     * "We recommend that you declare consistently-named identifier attributes on persistent classes
     * and that you use a nullable (i.e., non-primitive) type."
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    /*
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Jogo() {}

    public Jogo(String nome, String descricao, String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

}
