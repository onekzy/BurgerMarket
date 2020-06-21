package com.market.burgermarket.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ingredients")
public class Ingredient extends EntityBase {
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "cost")
    private BigDecimal cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "burger_id", referencedColumnName = "id")
    private Burger burger;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
