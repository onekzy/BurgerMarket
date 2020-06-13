package com.market.burgermarket.repositories;

import com.market.burgermarket.entities.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BurgerRepository extends CrudRepository<Burger, Long>, JpaRepository<Burger, Long> {
}
