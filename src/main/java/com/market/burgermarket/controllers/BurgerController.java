package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.Burger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/burger")
public class BurgerController {

    @GetMapping("{id}")
    public Burger getBurger(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping
    public Burger updateBurger(@RequestBody Burger burger) {
        return null;
    }

    @PutMapping
    public Burger saveBurger(@RequestBody Burger burger) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteBurger(@PathVariable("id") int id) {
        return;
    }
}
