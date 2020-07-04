package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.BurgerDto;
import com.market.burgermarket.dto.CartDto;
import com.market.burgermarket.dto.TicketDto;
import com.market.burgermarket.entities.*;
import com.market.burgermarket.repositories.CartRepository;
import com.market.burgermarket.repositories.TicketRepository;
import com.market.burgermarket.repositories.UserRepository;
import com.market.burgermarket.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final ConversionService conversionService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, TicketRepository ticketRepository, ConversionService conversionService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
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
    public CartDto updateCart(Long userId, CartDto cartDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        Cart cart = user.getCart();
        List<BigDecimal> burgersCosts = new ArrayList<>();
        List<BigDecimal> noDiscountBurgersCosts = new ArrayList<>();
        for (Burger burger : cart.getBurgers()) {
            BigDecimal cost = burger.getIngredients()
                    .stream()
                    .map(Ingredient::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            noDiscountBurgersCosts.add(cost);
            burgersCosts.add(cost.multiply(new BigDecimal(1)
                    .subtract(burger.getDiscount()
                            .divide(new BigDecimal(100)))));
        }
        BigDecimal totalCost = burgersCosts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal noDiscountCost = noDiscountBurgersCosts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setDeliveryIncluded(cartDto.isDeliveryIncluded());
        cart.setBurgersCost(totalCost);
        cart.setDiscount((totalCost.divide(noDiscountCost).multiply(new BigDecimal(100))));
        return conversionService.convert(cartRepository.save(cart), CartDto.class);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart is not found"));
        cartRepository.delete(cart);
    }

    @Override
    public List<BurgerDto> getBurgersByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        List<BurgerDto> burgerList = user.getCart().getBurgers()
                .stream()
                .map(burger -> conversionService.convert(burger, BurgerDto.class))
                .collect(Collectors.toList());
        return burgerList;
    }

    @Override
    public TicketDto createTicket(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));
        Cart cart = user.getCart();
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setCost(cart.getBurgersCost());
        List<Burger> burgers = cart.getBurgers();
        ticket.setBurgers(new ArrayList(burgers));
        ticket.setDiscount(cart.getDiscount());
        ticket.setPaid(false);
        return conversionService.convert(ticketRepository.save(ticket), TicketDto.class);
    }
}
