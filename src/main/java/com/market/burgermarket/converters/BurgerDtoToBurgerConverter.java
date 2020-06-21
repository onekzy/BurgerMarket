package com.market.burgermarket.converters;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.entities.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BurgerDtoToBurgerConverter implements Converter<BurgerDto, Burger> {
    private final CartDtoToCartConverter ca;

    @Autowired
    public BurgerDtoToBurgerConverter(CartDtoToCartConverter ca) {
        this.ca = ca;
    }

    @Override
    public Burger convert(BurgerDto burgerDto) {
        Burger burger = new Burger();
        burger.setId(burgerDto.getId());
        burger.setName(burgerDto.getName());
        burger.setCart(ca.convert(burgerDto.getCart()));
        return burger;
    }
}
