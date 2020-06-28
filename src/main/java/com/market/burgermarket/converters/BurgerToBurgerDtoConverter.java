package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.dto.MenuDto;
import com.market.burgermarket.entities.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BurgerToBurgerDtoConverter implements Converter<Burger, BurgerDto> {
    private final ConversionService conversionService;

    @Autowired
    public BurgerToBurgerDtoConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public BurgerDto convert(Burger burger) {
        BurgerDto target = new BurgerDto();
        target.setId(burger.getId());
        target.setName(burger.getName());
        target.setCart(conversionService.convert(burger.getCart(), CartDto.class));
        target.setMenu(conversionService.convert(burger.getMenu(), MenuDto.class));
        return target;
    }
}
