package com.market.burgermarket.services;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.MenuDto;

import java.util.List;

public interface MenuService {
    MenuDto getMenuById(Long id);

    List<MenuDto> getAll();

    MenuDto createMenu(MenuDto menuDto);

    MenuDto updateMenu(MenuDto menuDto);

    void deleteMenu(Long id);

    List<BurgerDto> getAllBurgers();

    List<BurgerDto> getBurgersByMenu(Long menuId);

    BurgerDto createOrder(Long userId, BurgerDto burgerDto);
}
