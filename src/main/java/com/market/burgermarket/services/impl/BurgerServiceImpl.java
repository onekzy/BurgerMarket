package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.entities.Menu;
import com.market.burgermarket.repositories.BurgerRepository;
import com.market.burgermarket.repositories.MenuRepository;
import com.market.burgermarket.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BurgerServiceImpl implements BurgerService {
    private final BurgerRepository burgerRepository;
    private final MenuRepository menuRepository;
    private final ConversionService conversionService;

    @Autowired
    public BurgerServiceImpl(BurgerRepository burgerRepository, MenuRepository menuRepository, ConversionService conversionService) {
        this.burgerRepository = burgerRepository;
        this.menuRepository = menuRepository;
        this.conversionService = conversionService;
    }

    @Override
    public BurgerDto getBurgerById(Long id) {
        Burger burger = burgerRepository.findById(id).orElseThrow(() -> new RuntimeException("Burger is not found"));
        return conversionService.convert(burger, BurgerDto.class);
    }

    @Override
    public List<BurgerDto> getAll() {
        List<Burger> burgers = burgerRepository.findAll();
        return burgers.stream().map(burger -> conversionService.convert(burger, BurgerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BurgerDto createBurger(Long menuId, BurgerDto burgerDto) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu is not found"));
        Burger burger = conversionService.convert(burgerDto, Burger.class);
        burger.setMenu(menu);
        menu.getBurgers().add(burger);
        return conversionService.convert(burgerRepository.save(burger), BurgerDto.class);
    }

    @Override
    public BurgerDto updateBurger(BurgerDto burgerDto) {
        Burger burger = burgerRepository
                .findById(burgerDto.getId()).orElseThrow(() -> new RuntimeException("Burger is not found"));
        burger.setName(burgerDto.getName());
        burger.setDiscount(burgerDto.getDiscount());
        return conversionService.convert(burgerRepository.save(burger), BurgerDto.class);
    }

    @Override
    public void deleteBurger(Long id) {
        Burger burger = burgerRepository.findById(id).orElseThrow(() -> new RuntimeException("Burger is not found"));
        burgerRepository.delete(burger);
    }
}
