package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.MenuDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Menu;
import com.market.burgermarket.entities.User;
import com.market.burgermarket.repositories.BurgerRepository;
import com.market.burgermarket.repositories.MenuRepository;
import com.market.burgermarket.repositories.UserRepository;
import com.market.burgermarket.services.MenuService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;
    private final BurgerRepository burgerRepository;
    private final ConversionService conversionService;

    public MenuServiceImpl(MenuRepository menuRepository, UserRepository userRepository, BurgerRepository burgerRepository, ConversionService conversionService) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.burgerRepository = burgerRepository;
        this.conversionService = conversionService;
    }

    @Override
    public MenuDto getMenuById(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu is not found"));
        return conversionService.convert(menu, MenuDto.class);
    }

    @Override
    public List<MenuDto> getAll() {
        List<Menu> menuList = menuRepository.findAll();
        return menuList.stream()
                .map(menu -> conversionService.convert(menu, MenuDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = conversionService.convert(menuDto, Menu.class);
        return conversionService.convert(menuRepository.save(menu), MenuDto.class);
    }

    @Override
    public MenuDto updateMenu(MenuDto menuDto) {
        Menu menu = menuRepository
                .findById(menuDto.getId()).orElseThrow(() -> new RuntimeException("Menu is not found"));
        menu.setName(menuDto.getName());
        return conversionService.convert(menuRepository.save(menu), MenuDto.class);
    }

    @Override
    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu is not found"));
        menuRepository.delete(menu);
    }

    @Override
    public List<BurgerDto> getAllBurgers() {
        return menuRepository.findAll()
                .stream()
                .map(Menu::getBurgers)
                .flatMap(Collection::stream)
                .map(burger -> conversionService.convert(burger, BurgerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BurgerDto> getBurgersByMenu(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu is not found"));
        return menu.getBurgers()
                .stream()
                .map(burger -> conversionService.convert(burger, BurgerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BurgerDto createOrder(Long userId, BurgerDto burgerDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        Burger burger = burgerRepository.findById(burgerDto.getId())
                .orElseThrow(() -> new RuntimeException("Burger is not found"));
        user.getCart().getBurgers().add(burger);
        burger.setCart(user.getCart());
        return conversionService.convert(burgerRepository.save(burger), BurgerDto.class);
    }
}
