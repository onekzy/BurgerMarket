package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.Cart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/cart")
public class CartController {

    @GetMapping("{id}")
    public Cart getCart(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return null;
    }

    @PutMapping
    public Cart saveCart(@RequestBody Cart cart) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteCart(@PathVariable("id") int id) {
        return;
    }
}
