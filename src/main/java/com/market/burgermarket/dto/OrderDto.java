package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.User;

import java.io.Serializable;
import java.util.List;

public class OrderDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("cost")
    private double cost;
    @JsonProperty("user")
    private User user;
    @JsonProperty("burgers")
    private List<Burger> burgers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }
}
