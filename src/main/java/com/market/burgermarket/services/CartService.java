package com.market.burgermarket.services;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto getCartById(Long id);
    List<CartDto> getAll();
    CartDto createCart(CartDto cartDto);
    CartDto updateCart(CartDto cartDto);
    void deleteCart(Long id);
    List<BurgerDto> getBurgersByUser(Long userId);
}
