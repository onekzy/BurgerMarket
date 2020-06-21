package com.market.burgermarket.converters;

import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.Address;
import com.market.burgermarket.entities.Cart;
import com.market.burgermarket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    private final ConversionService conversionService;

    @Autowired
    public UserDtoToUserConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(conversionService.convert(userDto.getAddress(), Address.class));
        user.setCart(conversionService.convert(userDto.getAddress(), Cart.class));
        return user;
    }
}
