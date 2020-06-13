package com.market.burgermarket.repositories;

import com.market.burgermarket.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long>, JpaRepository<Cart, Long> {
}
