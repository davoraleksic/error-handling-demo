package com.daleksic.errorhandlingdemo.service;

import com.daleksic.errorhandlingdemo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    void deleteById(Long id);
}
