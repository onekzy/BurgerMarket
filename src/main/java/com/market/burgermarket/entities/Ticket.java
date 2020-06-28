package com.market.burgermarket.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket extends EntityBase {
    @Column(name = "total_cost")
    private BigDecimal cost;
    @OneToMany
    private List<Burger> burgers;

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }
}
