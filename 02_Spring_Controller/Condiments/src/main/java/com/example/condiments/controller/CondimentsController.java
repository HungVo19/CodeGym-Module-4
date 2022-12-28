package com.example.condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentsController {
    @GetMapping()
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView getCondiments(@RequestParam(name = "condiments", required = false) String[] Condiments) {
        ModelAndView modelAndView = new ModelAndView("index");
        String[] list = Condiments;
        modelAndView.addObject("listC", list);
        return modelAndView;
    }
}
