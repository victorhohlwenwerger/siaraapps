package br.com.siaraapps.mtgdb.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity  // Indica que esta classe é uma entidade JPA
public class Deck {

    @Id  // chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Define a estratégia de geração do valor da chave primária como auto-incremento
    private Integer id;

    @Column(nullable = false)  // não pode ser nulo no banco de dados
    private String nome;

    @Column  // coluna de cores
    private String cores;

    @Column  // coluna tipo
    private String tipo;

    @Column  // coluna quantidade
    private Integer quantidade;

    @Column(name = "valor", columnDefinition = "decimal(12,2)")  // Define uma coluna com o nome "valor" e tipo decimal no banco de dados
    private BigDecimal valor;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)  // Define a relação um-para-muitos com a entidade Card
    private Set<Card> cards = new HashSet<>();

    public Deck() {
    }

    public Deck(String nome, String cores, String tipo, Integer quantidade, BigDecimal valor) {
        this.nome = nome;
        this.cores = cores;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
        card.setDeck(this);  // Define a relação bidirecional, associando o Card ao Deck
    }

    public void removeCard(Card card) {
        cards.remove(card);
        card.setDeck(null);  // Remove a associação bidirecional, desassociando o Card do Deck
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cores='" + cores + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
