package com.market.burgermarket.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "delivery_included")
    private boolean deliveryIncluded;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToMany
    private List<Burger> burgers;
    @Column(name = "cost")
    private BigDecimal burgersCost;

    public boolean isEmpty() {
        return burgers.isEmpty();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
