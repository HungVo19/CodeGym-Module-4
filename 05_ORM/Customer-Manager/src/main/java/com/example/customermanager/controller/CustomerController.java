package com.example.customermanager.controller;

import com.example.customermanager.service.impl.HibernateCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private HibernateCustomerServiceImpl customerService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }
}
