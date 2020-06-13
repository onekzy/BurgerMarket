package com.market.burgermarket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.burgermarket.entities.Ingredient;

import java.io.Serializable;
import java.util.List;

public class BurgerDto implements Serializable {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("id")
    private String name;
    @JsonProperty("ingredients")
    private List<Ingredient> ingredients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
