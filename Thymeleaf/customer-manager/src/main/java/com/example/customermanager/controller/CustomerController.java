package com.example.customermanager.controller;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.ICRUDCore;
import com.example.customermanager.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("index");
        ArrayList<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

//    @GetMapping("/showForm/{id}")
//    public ModelAndView showForm (@PathVariable Long id) {
//        ModelAndView modelAndView = new ModelAndView("create");
//
//    }

    @GetMapping("/showForm/{id}")
    public ModelAndView showForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        if (id == -1) {
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("button", customerService.findAllButtons().get(1));
        } else {
            modelAndView.addObject("customer",customerService.findOne(id));
            modelAndView.addObject("button", customerService.findAllButtons().get(2));
        }
        return modelAndView;
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message","the list is updated successfully");
        return "redirect:/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }

    @RequestMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("customer",customerService.findOne(id));
        modelAndView.addObject("button",customerService.findAllButtons().get(0));
        return modelAndView;
    }

}
