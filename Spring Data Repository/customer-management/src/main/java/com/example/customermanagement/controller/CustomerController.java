package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.Province;
import com.example.customermanagement.service.ICustomerService;
import com.example.customermanagement.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(Pageable pageable){
        return provinceService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showList(@PageableDefault(size = 2) Pageable pageable,
                                 @RequestParam(name = "search" ) Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (!search.isPresent()) {
            modelAndView.addObject("customers", customerService.findAll(pageable));
        } else {
            modelAndView.addObject("customers",customerService.findAllByLastNameContaining(search.get(),pageable));
            modelAndView.addObject("search",search.get());
        }
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
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            modelAndView.addObject("customer", customer.get());
        } else {
            return new ModelAndView("index");
        }
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
