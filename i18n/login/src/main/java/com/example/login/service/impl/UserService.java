package com.example.login.service.impl;

import com.example.login.model.User;
import com.example.login.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private static List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User("user","12345"));
    }
    @Override
    public User findById(Long aLong) {
        return list.get(0);
    }
}
