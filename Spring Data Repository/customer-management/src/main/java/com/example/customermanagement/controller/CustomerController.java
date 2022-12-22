package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.Province;
import com.example.customermanagement.service.ICustomerService;
import com.example.customermanagement.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        customerService.remove(id);
        return "redirect:/customers";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("customer", customerService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
