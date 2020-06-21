package com.market.burgermarket.services;

import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.entities.Cart;
import com.market.burgermarket.repositories.CartRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ConversionService conversionService;

    public CartServiceImpl(CartRepository cartRepository, ConversionService conversionService) {
        this.cartRepository = cartRepository;
        this.conversionService = conversionService;
    }

    @Override
    public CartDto getCartById(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart is not found"));
        return conversionService.convert(cart, CartDto.class);
    }

    @Override
    public List<CartDto> getAll() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map(cart -> conversionService.convert(cart, CartDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartDto createCart(CartDto cartDto) {
        Cart cart = conversionService.convert(cartDto, Cart.class);
        return conversionService.convert(cartRepository.save(cart), CartDto.class);
    }

    @Override
    public CartDto updateCart(CartDto cartDto) {
        Cart cart = cartRepository
                .findById(cartDto.getId()).orElseThrow(() -> new RuntimeException("Cart is not found"));
        cart.setDeliveryIncluded(cartDto.isDeliveryIncluded());
        cart.setBurgersCost(cartDto.getBurgersCost());
        return conversionService.convert(cartRepository.save(cart), CartDto.class);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart is not found"));
        cartRepository.delete(cart);
    }
}
