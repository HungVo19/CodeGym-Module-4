package com.example.customermanager.controller;

import com.example.customermanager.exception.DuplicateEmailException;
import com.example.customermanager.model.User;
import com.example.customermanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        try{
            return new ModelAndView("form", "user", userService.findById(id).get());
        } catch (Exception e) {
            return new ModelAndView("redirect:/users/list");
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        try{
            userService.save(user);
            return "redirect:/users/list";
        } catch (Exception e) {
            return "error";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) throws Exception {
        userService.deleteById(id);
        return "redirect:/users/list";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView showErrorPage() {
        return new ModelAndView("error");
    }
}
