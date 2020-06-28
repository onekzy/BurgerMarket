package com.market.burgermarket.converters;

import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientDtoToIngredientConverter implements Converter<IngredientDto, Ingredient> {
    private final ConversionService conversionService;

    @Autowired
    public IngredientDtoToIngredientConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Ingredient convert(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        ingredient.setType(ingredientDto.getType());
        ingredient.setPrice(ingredientDto.getPrice());
        ingredient.setBurger(conversionService.convert(ingredientDto.getBurger(), Burger.class));
        return ingredient;
    }
}
