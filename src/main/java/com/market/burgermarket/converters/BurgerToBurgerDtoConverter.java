package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.entities.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BurgerToBurgerDtoConverter implements Converter<Burger, BurgerDto> {
    private final CartToCartDtoConverter ca;

    @Autowired
    public BurgerToBurgerDtoConverter(CartToCartDtoConverter ca) {
        this.ca = ca;
    }

    @Override
    public BurgerDto convert(Burger burger) {
        BurgerDto target = new BurgerDto();
        target.setId(burger.getId());
        target.setName(burger.getName());
        target.setCart(ca.convert(burger.getCart()));
        return target;
    }
}
