package com.example.springbootspringdatajpa.service;

import com.example.springbootspringdatajpa.dto.UserDto;
import com.example.springbootspringdatajpa.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}