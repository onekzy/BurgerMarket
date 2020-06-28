package com.market.burgermarket.converters;

import com.market.burgermarket.dto.AddressDto;
import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    private final ConversionService conversionService;

    @Autowired
    public UserToUserDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public UserDto convert(User user) {
        UserDto target = new UserDto();
        target.setId(user.getId());
        target.setFirstName(user.getFirstName());
        target.setLastName(user.getLastName());
        target.setEmail(user.getEmail());
        target.setAddress(conversionService.convert(user.getAddress(), AddressDto.class));
        target.setCart(conversionService.convert(user.getCart(), CartDto.class));
        return target;
    }
}
