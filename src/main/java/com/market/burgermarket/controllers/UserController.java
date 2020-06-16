package com.market.burgermarket.controllers;

import com.market.burgermarket.entities.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") int id) {
        return null;
    }

    @PostMapping
    public User updateUser(@RequestBody User user) {
        return null;
    }

    @PutMapping
    public User saveUser(@RequestBody User user) {
        return null;
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") int id) {
        return;
    }
}
