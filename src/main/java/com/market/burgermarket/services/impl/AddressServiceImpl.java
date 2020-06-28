package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.AddressDto;
import com.market.burgermarket.entities.Address;
import com.market.burgermarket.repositories.AddressRepository;
import com.market.burgermarket.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ConversionService conversionService;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ConversionService conversionService) {
        this.addressRepository = addressRepository;
        this.conversionService = conversionService;
    }

    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address is not found"));
        return conversionService.convert(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(address -> conversionService.convert(address, AddressDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = conversionService.convert(addressDto, Address.class);
        return conversionService.convert(addressRepository.save(address), AddressDto.class);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = addressRepository
                .findById(addressDto.getId()).orElseThrow(() -> new RuntimeException("Address is not found"));
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setRoom(addressDto.getRoom());
        return conversionService.convert(addressRepository.save(address), AddressDto.class);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address is not found"));
        addressRepository.delete(address);
    }
}
