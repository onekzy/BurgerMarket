package com.market.burgermarket.services.impl;

import com.market.burgermarket.dto.UserDto;
import com.market.burgermarket.entities.User;
import com.market.burgermarket.repositories.UserRepository;
import com.market.burgermarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }


    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Person is not found"));
        return conversionService.convert(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(person -> conversionService.convert(person, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        return conversionService.convert(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepository
                .findById(userDto.getId()).orElseThrow(() -> new RuntimeException("Person is not found"));
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        return conversionService.convert(userRepository.save(user), UserDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Person is not found"));
        userRepository.delete(user);
    }
}
