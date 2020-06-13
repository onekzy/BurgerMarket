package com.market.burgermarket.repositories;

import com.market.burgermarket.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>, JpaRepository<Order, Long> {
}
