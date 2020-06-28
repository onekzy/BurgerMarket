package com.market.burgermarket.converters;

import com.market.burgermarket.dto.MenuDto;
import com.market.burgermarket.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MenuToMenuDtoConverter implements Converter<Menu, MenuDto> {
    private final ConversionService conversionService;

    @Autowired
    public MenuToMenuDtoConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public MenuDto convert(Menu menu) {
        MenuDto target = new MenuDto();
        target.setId(menu.getId());
        target.setName(menu.getName());
        return target;
    }
}
