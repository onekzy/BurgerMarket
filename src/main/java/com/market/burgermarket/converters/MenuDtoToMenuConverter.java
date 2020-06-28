package com.market.burgermarket.converters;

import com.market.burgermarket.dto.MenuDto;
import com.market.burgermarket.entities.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MenuDtoToMenuConverter implements Converter<MenuDto, Menu> {
    private final ConversionService conversionService;

    @Autowired
    public MenuDtoToMenuConverter(@Lazy ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Menu convert(MenuDto menuDto) {
        Menu menu = new Menu();
        menu.setId(menuDto.getId());
        menu.setName(menuDto.getName());
        return menu;
    }
}
