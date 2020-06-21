package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartDto> getAllCarts() {
        return cartService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CartDto getCart(@PathVariable("id") Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping
    public CartDto updateCart(@RequestBody CartDto cartDto) {
        return cartService.updateCart(cartDto);
    }

    @PutMapping
    public CartDto saveCart(@RequestBody CartDto cartDto) {
        return cartService.createCart(cartDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
    }
}
