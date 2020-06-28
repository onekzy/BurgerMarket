package com.market.burgermarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends EntityBase {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Burger> burgers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }
}
