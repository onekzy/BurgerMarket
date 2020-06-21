package com.market.burgermarket.converters;

import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.entities.Cart;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CartDtoToCartConverter implements Converter<CartDto, Cart> {

    @Override
    public Cart convert(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setBurgersCost(cartDto.getBurgersCost());
        cart.setDeliveryIncluded(cartDto.isDeliveryIncluded());
        return cart;
    }
}
