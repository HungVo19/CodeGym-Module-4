package com.example.registerform.service;

import com.example.registerform.model.User;
import com.example.registerform.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    IRegisterRepository registerRepository;

    @Override
    public Iterable<User> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        if (registerRepository.findById(id).isPresent()) {
            return registerRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void save(User user) {
        registerRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        registerRepository.deleteById(id);
    }
}
