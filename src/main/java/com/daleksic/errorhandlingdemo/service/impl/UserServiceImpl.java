package com.daleksic.errorhandlingdemo.service.impl;

import com.daleksic.errorhandlingdemo.entity.User;
import com.daleksic.errorhandlingdemo.exception.GenericValidationException;
import com.daleksic.errorhandlingdemo.repository.UserRepository;
import com.daleksic.errorhandlingdemo.service.UserService;
import com.daleksic.errorhandlingdemo.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserValidation userValidation;
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Middle name is blank"));
        return user;
    }

    @Override
    public User create(User user) {
        userValidation.validate(user);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
