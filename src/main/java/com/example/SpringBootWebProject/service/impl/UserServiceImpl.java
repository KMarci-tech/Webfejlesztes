package com.example.SpringBootWebProject.service.impl;

import com.example.SpringBootWebProject.dto.UserDto;
import com.example.SpringBootWebProject.model.User;
import com.example.SpringBootWebProject.repository.UserRepository;
import com.example.SpringBootWebProject.service.UserService;

import com.example.SpringBootWebProject.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserDto> getAllUsers() {
        List<User> entities = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();

        dtos = userMapper.userEntityListToDtoList(entities);

        return dtos;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return userMapper.userEntityToDto(user);
        } else {
            return null; // Vagy hibaüzenet, ha nincs találat
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // UserDto konvertálása User entitássá a UserMapper segítségével
        User user = userMapper.userDtoToEntity(userDto);
        // User mentése az adatbázisba a userRepository segítségével
        User newUser = userRepository.save(user);
        return userMapper.userEntityToDto(newUser);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        // Ellenőrizd, hogy a felhasználó létezik-e
        if (!userRepository.existsById(userId)) {
            return null; // Vagy hibaüzenet, ha a felhasználó nem létezik
        }

        // UserDto konvertálása User entitássá a UserMapper segítségével
        User updatedUser = userMapper.userDtoToEntity(userDto);
        updatedUser.setId(userId); // Állítsd be az ID-t a meglévő felhasználó ID-jára

        // User frissítése az adatbázisban a userRepository segítségével
        User savedUser = userRepository.save(updatedUser);
        return userMapper.userEntityToDto(savedUser);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        } else {
            return false; // Vagy hibaüzenet, ha a felhasználó nem létezik
        }
    }
}