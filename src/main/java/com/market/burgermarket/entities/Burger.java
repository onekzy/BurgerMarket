package com.market.burgermarket.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "burgers")
public class Burger extends EntityBase {
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
    @OneToMany(mappedBy = "burger", cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
