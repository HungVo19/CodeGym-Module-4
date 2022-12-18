package com.example.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam(name = "operand1") Double operand1, @RequestParam(name = "operand2") Double operand2,
                                  @RequestParam(name = "calculate") String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        Double result = null;
        switch (operator) {
            case "+" :
                result = operand1 + operand2;
                break;
            case "-" :
                result = operand1 - operand2;
                break;
            case "x" :
                result = operand1 * operand2;
                break;
            case "/" :
                result = operand1/operand2;
                break;
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }

}
