package com.market.burgermarket.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends EntityBase {
    @Column(name = "delivery_included")
    private boolean deliveryIncluded;
    @OneToOne(mappedBy = "cart")
    private User user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Burger> burgers;
    @Column(name = "cost")
    private BigDecimal burgersCost;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEmpty() {
        return burgers.isEmpty();
    }

    public boolean isDeliveryIncluded() {
        return deliveryIncluded;
    }

    public void setDeliveryIncluded(boolean deliveryIncluded) {
        this.deliveryIncluded = deliveryIncluded;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }

    public BigDecimal getBurgersCost() {
        return burgersCost;
    }

    public void setBurgersCost(BigDecimal burgersCost) {
        this.burgersCost = burgersCost;
    }
}
