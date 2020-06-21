package com.market.burgermarket.converters;

import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.entities.Cart;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CartToCartDtoConverter implements Converter<Cart, CartDto> {

    @Override
    public CartDto convert(Cart cart) {
        CartDto target = new CartDto();
        target.setId(cart.getId());
        target.setBurgersCost(cart.getBurgersCost());
        target.setDeliveryIncluded(cart.isDeliveryIncluded());
        return target;
    }
}
