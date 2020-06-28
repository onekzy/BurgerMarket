package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.MenuDto;
import com.market.burgermarket.services.BurgerService;
import com.market.burgermarket.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/menu")
public class MenuController {
    private final MenuService menuService;
    private final BurgerService burgerService;

    @Autowired
    public MenuController(MenuService menuService, BurgerService burgerService) {
        this.menuService = menuService;
        this.burgerService = burgerService;
    }

    @GetMapping
    public List<MenuDto> getMenu() {
        return menuService.getAll();
    }

    @GetMapping(value = "/burgers")
    public List<BurgerDto> getAllBurgers() {
        return menuService.getAllBurgers();
    }

    @GetMapping(value = "/{menuId}/burgers")
    public List<BurgerDto> getBurgersByMenu(@PathVariable(value = "menuId") Long menuId) {
        return menuService.getBurgersByMenu(menuId);
    }

    @GetMapping(value = "/{id}")
    public MenuDto getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public MenuDto createMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }

    @PostMapping(value = "/{menuId}/burger")
    public BurgerDto createBurger(@PathVariable(value = "menuId") Long menuId, @RequestBody BurgerDto burgerDto) {
        return burgerService.createBurger(menuId, burgerDto);
    }

    @PutMapping
    public BurgerDto buyBurger(@PathVariable(value = "userId") Long userId,
                               @RequestBody BurgerDto burgerDto) {
        return menuService.createOrder(userId, burgerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMenu(@PathVariable(value = "id") Long id) {
        menuService.deleteMenu(id);
    }

}
