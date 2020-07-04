package com.market.burgermarket.services;

import com.market.burgermarket.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto getAddressById(Long id);

    List<AddressDto> getAll();

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(AddressDto addressDto);

    void deleteAddress(Long id);
}
