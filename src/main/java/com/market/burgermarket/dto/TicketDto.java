package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.burgermarket.entities.Burger;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TicketDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("total_cost")
    private BigDecimal cost;
    @JsonProperty("ordered_burgers")
    private List<Burger> burgers;

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
