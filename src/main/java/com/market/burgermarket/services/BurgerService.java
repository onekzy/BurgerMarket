package com.market.burgermarket.services;

import com.market.burgermarket.dto.BurgerDto;

import java.util.List;

public interface BurgerService {
    BurgerDto getBurgerById(Long id);
    List<BurgerDto> getAll();
    BurgerDto createBurger(BurgerDto burgerDto);
    BurgerDto updateBurger(BurgerDto burgerDto);
    void deleteBurger(Long id);
}
