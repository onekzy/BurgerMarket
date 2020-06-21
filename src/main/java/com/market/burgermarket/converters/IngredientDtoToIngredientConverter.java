package com.market.burgermarket.converters;

import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientDtoToIngredientConverter implements Converter<IngredientDto, Ingredient> {
    private final BurgerDtoToBurgerConverter bu;

    @Autowired
    public IngredientDtoToIngredientConverter(BurgerDtoToBurgerConverter bu) {
        this.bu = bu;
    }

    @Override
    public Ingredient convert(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setType(ingredientDto.getType());
        ingredient.setCost(ingredientDto.getCost());
        ingredient.setBurger(bu.convert(ingredientDto.getBurger()));
        return ingredient;
    }
}
