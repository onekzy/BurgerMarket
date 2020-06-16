package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.Address;
import com.market.burgermarket.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/address")
public class AddressController {

    @GetMapping("{id}")
    public Address getAddress(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping
    public Address updateAddress(@RequestBody Address address) {
        return null;
    }

    @PutMapping
    public Address saveAddress(@RequestBody Address address) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteAddress(@PathVariable("id") int id) {
        return;
    }
}
