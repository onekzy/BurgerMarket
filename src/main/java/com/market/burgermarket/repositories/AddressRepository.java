package com.market.burgermarket.repositories;

import com.market.burgermarket.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>, JpaRepository<Address, Long> {
}
