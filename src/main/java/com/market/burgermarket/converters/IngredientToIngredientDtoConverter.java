package com.market.burgermarket.converters;

import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDtoConverter implements Converter<Ingredient, IngredientDto> {
    private final BurgerToBurgerDtoConverter bu;

    @Autowired
    public IngredientToIngredientDtoConverter(BurgerToBurgerDtoConverter bu) {
        this.bu = bu;
    }

    @Override
    public IngredientDto convert(Ingredient ingredient) {
        IngredientDto target = new IngredientDto();
        target.setId(ingredient.getId());
        target.setName(ingredient.getName());
        target.setType(ingredient.getType());
        target.setCost(ingredient.getCost());
        target.setBurger(bu.convert(ingredient.getBurger()));
        return target;
    }
}
