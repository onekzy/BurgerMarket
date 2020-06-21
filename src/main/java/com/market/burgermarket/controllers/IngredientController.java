package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients() {
        return ingredientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public IngredientDto getIngredient(@PathVariable("id") Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping
    public IngredientDto updateIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.updateIngredient(ingredientDto);
    }

    @PutMapping
    public IngredientDto saveIngredient(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.createIngredient(ingredientDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteIngredient(@PathVariable("id") Long id) {
        ingredientService.deleteIngredient(id);
    }
}
