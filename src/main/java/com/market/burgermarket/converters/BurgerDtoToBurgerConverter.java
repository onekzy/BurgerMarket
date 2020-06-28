package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Cart;
import com.market.burgermarket.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BurgerDtoToBurgerConverter implements Converter<BurgerDto, Burger> {
    private final ConversionService conversionService;

    @Autowired
    public BurgerDtoToBurgerConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Burger convert(BurgerDto burgerDto) {
        Burger burger = new Burger();
        burger.setId(burgerDto.getId());
        burger.setName(burgerDto.getName());
        burger.setCart(conversionService.convert(burgerDto.getCart(), Cart.class));
        burger.setMenu(conversionService.convert(burgerDto.getMenu(), Menu.class));
        return burger;
    }
}
