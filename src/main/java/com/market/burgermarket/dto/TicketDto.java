package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TicketDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonIgnore
    private UserDto user;
    @JsonProperty("cost")
    private BigDecimal cost;
    @JsonProperty("discount")
    private BigDecimal discount;
    @JsonProperty("burgers")
    private List<BurgerDto> burgers;
    @JsonProperty("paid")
    private Boolean paid;

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<BurgerDto> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<BurgerDto> burgers) {
        this.burgers = burgers;
    }
}
