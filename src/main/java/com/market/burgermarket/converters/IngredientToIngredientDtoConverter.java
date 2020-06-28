package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.entities.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDtoConverter implements Converter<Ingredient, IngredientDto> {
    private final ConversionService conversionService;

    @Autowired
    public IngredientToIngredientDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public IngredientDto convert(Ingredient ingredient) {
        IngredientDto target = new IngredientDto();
        target.setId(ingredient.getId());
        target.setName(ingredient.getName());
        target.setType(ingredient.getType());
        target.setPrice(ingredient.getPrice());
        target.setBurger(conversionService.convert(ingredient.getBurger(), BurgerDto.class));
        return target;
    }
}
