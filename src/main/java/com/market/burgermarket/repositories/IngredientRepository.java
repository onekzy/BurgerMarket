package com.market.burgermarket.repositories;

import com.market.burgermarket.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long>, JpaRepository<Ingredient, Long> {
}
