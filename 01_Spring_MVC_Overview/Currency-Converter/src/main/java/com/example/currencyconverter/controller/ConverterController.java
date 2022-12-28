package com.example.currencyconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConverterController {
    @PostMapping("/converter")
    public ModelAndView convert(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double result = Double.parseDouble(request.getParameter("usd")) * 23000;
        modelAndView.addObject("result",request.getParameter("usd") + " USD = " + result + " VND");
        return modelAndView;
    }
}
