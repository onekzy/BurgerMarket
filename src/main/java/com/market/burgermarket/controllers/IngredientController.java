package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.Ingredient;
import com.market.burgermarket.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/burger/ingredients")
public class IngredientController {

    @GetMapping("{id}")
    public Ingredient getIngredient(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
        return null;
    }

    @PutMapping
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable("id") int id) {
        return;
    }
}
