package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.services.BurgerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/burger")
public class BurgerController {
    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @GetMapping
    public List<BurgerDto> getAllBurgers() {
        return burgerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public BurgerDto getBurger(@PathVariable("id") Long id) {
        return burgerService.getBurgerById(id);
    }

    @PostMapping
    public BurgerDto updateBurger(@RequestBody BurgerDto burgerDto) {
        return burgerService.updateBurger(burgerDto);
    }

    @PutMapping
    public BurgerDto saveBurger(@RequestBody BurgerDto burgerDto) {
        return burgerService.createBurger(burgerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBurger(@PathVariable("id") Long id) {
        burgerService.deleteBurger(id);
    }
}
