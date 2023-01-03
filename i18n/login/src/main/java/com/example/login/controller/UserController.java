package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public ModelAndView showLoginForm() {
        return new ModelAndView("index","user",new User());
    }
}
