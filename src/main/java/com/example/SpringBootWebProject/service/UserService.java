package com.example.SpringBootWebProject.service;

import com.example.SpringBootWebProject.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long userId, UserDto userDto);
    boolean deleteUser(Long userId);
}
