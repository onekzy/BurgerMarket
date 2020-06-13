package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.User;

import java.io.Serializable;
import java.util.List;

public class CartDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("deliveryIncluded")
    private boolean deliveryIncluded;
    @JsonProperty("burgers")
    private List<Burger> burgers;
    @JsonProperty("burgersCost")
    private double burgersCost;

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

    public double getBurgersCost() {
        return burgersCost;
    }

    public void setBurgersCost(double burgersCost) {
        this.burgersCost = burgersCost;
    }
}
