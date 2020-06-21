package com.market.burgermarket.converters;

import com.market.burgermarket.dto.AddressDto;
import com.market.burgermarket.entities.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoToAddressConverter implements Converter<AddressDto, Address> {
    @Override
    public Address convert(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setRoom(addressDto.getRoom());
        return address;
    }
}
