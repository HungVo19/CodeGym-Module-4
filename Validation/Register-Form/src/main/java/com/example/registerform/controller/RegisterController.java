package com.example.registerform.controller;

import com.example.registerform.model.User;
import com.example.registerform.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Service
@RequestMapping("/form")
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", new User());
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            return new ModelAndView("index","user",new User());
            return "index";
        } else {
            registerService.save(user);
//            return new ModelAndView("result");
            return "result";
        }
    }
}
