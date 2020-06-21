package com.market.burgermarket.services;

import com.market.burgermarket.dto.IngredientDto;

import java.util.List;

public interface IngredientService {
    IngredientDto getIngredientById(Long id);
    List<IngredientDto> getAll();
    IngredientDto createIngredient(IngredientDto ingredientDto);
    IngredientDto updateIngredient(IngredientDto ingredientDto);
    void deleteIngredient(Long id);
}
