package com.market.burgermarket.converters;

import com.market.burgermarket.dto.AddressDto;
import com.market.burgermarket.entities.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToAddressDtoConverter implements Converter<Address, AddressDto> {
    @Override
    public AddressDto convert(Address address) {
        AddressDto target = new AddressDto();
        target.setId(address.getId());
        target.setCity(address.getCity());
        target.setStreet(address.getStreet());
        target.setBuilding(address.getBuilding());
        target.setRoom(address.getRoom());
        return target;
    }
}
