package com.market.burgermarket.converters;

import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    private final AddressToAddressDtoConverter ad;
    private final CartToCartDtoConverter ca;

    @Autowired
    public UserToUserDtoConverter(AddressToAddressDtoConverter ad, CartToCartDtoConverter ca) {
        this.ad = ad;
        this.ca = ca;
    }

    @Override
    public UserDto convert(User user) {
        UserDto target = new UserDto();
        target.setId(user.getId());
        target.setFirstName(user.getFirstName());
        target.setLastName(user.getLastName());
        target.setEmail(user.getEmail());
        target.setAddress(ad.convert(user.getAddress()));
        target.setCart(ca.convert(user.getCart()));
        return target;
    }
}
