package com.example.customermanager.service;

import com.example.customermanager.exception.DuplicateEmailException;
import com.example.customermanager.model.User;
import com.example.customermanager.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long aLong) throws Exception {
        Optional<User> userOptional = userRepository.findById(aLong);
        if (!userOptional.isPresent()) {
            throw new Exception("User not found!");
        }
        return userOptional;
    }

    @Override
    public void save(User user) throws Exception {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new Exception();
        }
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }
}
