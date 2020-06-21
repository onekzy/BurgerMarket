package com.market.burgermarket.converters;

import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    private final AddressDtoToAddressConverter ad;
    private final CartDtoToCartConverter ca;

    @Autowired
    public UserDtoToUserConverter(AddressDtoToAddressConverter ad, CartDtoToCartConverter ca) {
        this.ad = ad;
        this.ca = ca;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAddress(ad.convert(userDto.getAddress()));
        user.setCart(ca.convert(userDto.getCart()));
        return user;
    }
}
