package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.*;
import com.market.burgermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setEmail("onekzydead123@gmail.com");
        user.setFirstName("Alexey");
        user.setLastName("Ramaev");
        Address address = new Address();
        address.setId(1);
        address.setBuilding("56");
        address.setCity("NN");
        address.setStreet("Gagarina");
        address.setRoom("r44");
        user.setAddress(address);
        Cart cart = new Cart();
        cart.setId(1);
        cart.setDeliveryIncluded(true);
        cart.setBurgersCost(500.21);
        Burger burger = new Burger();
        burger.setId(1);
        burger.setName("MyBurger");
        Burger burger2 = new Burger();
        burger2.setId(3);
        burger2.setName("MyBurger2");
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setCost(10.00);
        ingredient.setName("cheese");
        ingredient.setType("additional");
        burger.setIngredients(Arrays.asList(ingredient));
        burger2.setIngredients(Arrays.asList(ingredient));
        cart.setBurgers(Arrays.asList(burger, burger2));
        user.setCart(cart);
        return user;
    }
}
