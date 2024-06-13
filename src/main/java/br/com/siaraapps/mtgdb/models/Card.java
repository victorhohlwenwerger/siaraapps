package br.com.siaraapps.mtgdb.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "cards")
public class Card {

    @Id
    @Column(name = "idcards")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(45)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(5)")
    private String colors;

    @Column(name = "mana_cost", columnDefinition = "tinyint")
    private Integer manaCost;

    @Column(columnDefinition = "varchar(45)")
    private String type;

    private Character rarity;

    @Column(columnDefinition = "tinyint")
    private Integer power;

    @Column(columnDefinition = "tinyint")
    private Integer toughness;

    @Column(columnDefinition = "varchar(45)")
    private String printing;

    @Column(columnDefinition = "tinyint(1)")
    private Boolean foil;

    private Integer quantity;

    @Column(name = "expected_value", columnDefinition = "decimal(12,2)")
    private BigDecimal exectedValue;

    //Construtor vazio (dependencia do JPA)
    public Card() {
    }

    public Card(String name, String colors, Integer manaCost, String type, Character rarity, Integer power, Integer toughness, String printing, Boolean foil, Integer quantity, BigDecimal exectedValue) {
        this.name = name;
        this.colors = colors;
        this.manaCost = manaCost;
        this.type = type;
        this.rarity = rarity;
        this.power = power;
        this.toughness = toughness;
        this.printing = printing;
        this.foil = foil;
        this.quantity = quantity;
        this.exectedValue = exectedValue;
    }

    //Constrututor com apenas os campos obrigatorios
    public Card(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Integer getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Character getRarity() {
        return rarity;
    }

    public void setRarity(Character rarity) {
        this.rarity = rarity;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getToughness() {
        return toughness;
    }

    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    public String getPrinting() {
        return printing;
    }

    public void setPrinting(String printing) {
        this.printing = printing;
    }

    public Boolean isFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getExectedValue() {
        return exectedValue;
    }

    public void setExectedValue(BigDecimal exéctedValue) {
        this.exectedValue = exéctedValue;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colors='" + colors + '\'' +
                ", manaCost=" + manaCost +
                ", type='" + type + '\'' +
                ", rarity=" + rarity +
                ", power=" + power +
                ", toughness=" + toughness +
                ", set=" + printing +
                ", foil=" + foil +
                ", quantity=" + quantity +
                ", exectedValue=" + exectedValue +
                '}';
    }
}
