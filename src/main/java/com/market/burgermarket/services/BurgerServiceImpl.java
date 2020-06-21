package com.market.burgermarket.services;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.entities.Burger;
import com.market.burgermarket.repositories.BurgerRepository;
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
    private final ConversionService conversionService;

    @Autowired
    public BurgerServiceImpl(BurgerRepository burgerRepository, ConversionService conversionService) {
        this.burgerRepository = burgerRepository;
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
    public BurgerDto createBurger(BurgerDto burgerDto) {
        Burger burger = conversionService.convert(burgerDto, Burger.class);
        return conversionService.convert(burgerRepository.save(burger), BurgerDto.class);
    }

    @Override
    public BurgerDto updateBurger(BurgerDto burgerDto) {
        Burger burger = burgerRepository
                .findById(burgerDto.getId()).orElseThrow(() -> new RuntimeException("Burger is not found"));
        burger.setName(burgerDto.getName());
        return conversionService.convert(burgerRepository.save(burger), BurgerDto.class);
    }

    @Override
    public void deleteBurger(Long id) {
        Burger burger = burgerRepository.findById(id).orElseThrow(() -> new RuntimeException("Burger is not found"));
        burgerRepository.delete(burger);
    }
}
