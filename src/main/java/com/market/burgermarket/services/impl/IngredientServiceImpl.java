package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.IngredientDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Ingredient;
import com.market.burgermarket.repositories.BurgerRepository;
import com.market.burgermarket.repositories.IngredientRepository;
import com.market.burgermarket.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final BurgerRepository burgerRepository;
    private final ConversionService conversionService;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository, BurgerRepository burgerRepository, ConversionService conversionService) {
        this.ingredientRepository = ingredientRepository;
        this.burgerRepository = burgerRepository;
        this.conversionService = conversionService;
    }

    @Override
    public IngredientDto getIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Ingredient is not found"));
        return conversionService.convert(ingredient, IngredientDto.class);
    }

    @Override
    public List<IngredientDto> getAll() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().map(ingredient -> conversionService.convert(ingredient, IngredientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDto createIngredient(Long burgerID, IngredientDto ingredientDto) {
        Ingredient ingredient = conversionService.convert(ingredientDto, Ingredient.class);
        Burger burger = burgerRepository.findById(burgerID).orElseThrow(() -> new RuntimeException("Burger is not found"));
        burger.getIngredients().add(ingredient);
        ingredient.setBurger(burger);
        return conversionService.convert(ingredientRepository.save(ingredient), IngredientDto.class);
    }

    @Override
    public IngredientDto updateIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientRepository
                .findById(ingredientDto.getId()).orElseThrow(() -> new RuntimeException("Ingredient is not found"));
        ingredient.setPrice(ingredientDto.getPrice());
        ingredient.setType(ingredientDto.getType());
        ingredientDto.setName(ingredientDto.getName());
        return conversionService.convert(ingredientRepository.save(ingredient), IngredientDto.class);
    }

    @Override
    public void deleteIngredient(Long id) {
        Ingredient ingredient = ingredientRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Ingredient is not found"));
        ingredientRepository.delete(ingredient);
    }
}
