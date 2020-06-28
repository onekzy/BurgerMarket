package com.market.burgermarket.controllers;

import com.market.burgermarket.dto.AddressDto;
import com.market.burgermarket.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> getAllAddresses() {
        return addressService.getAll();
    }

    @GetMapping(value = "/{id}")
    public AddressDto getAddress(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping
    public AddressDto updateAddress(@RequestBody AddressDto addressDto) {
        return addressService.updateAddress(addressDto);
    }

    @PostMapping
    public AddressDto saveAddress(@RequestBody AddressDto addressDto) {
        return addressService.createAddress(addressDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }
}
