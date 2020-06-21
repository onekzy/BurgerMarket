package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.burgermarket.entities.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("deliveryIncluded")
    private boolean deliveryIncluded;
    @JsonIgnore
    private User user;
    @JsonIgnore
    private List<BurgerDto> burgers;
    @JsonProperty("cost")
    private BigDecimal burgersCost;

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<BurgerDto> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<BurgerDto> burgers) {
        this.burgers = burgers;
    }

    public BigDecimal getBurgersCost() {
        return burgersCost;
    }

    public void setBurgersCost(BigDecimal burgersCost) {
        this.burgersCost = burgersCost;
    }
}
