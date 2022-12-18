package com.example.dictionary.controller;

import com.example.dictionary.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictController {
    @Autowired
    private DictService dictService;

    @GetMapping(value = "/lookup")
    public ModelAndView lookUp (@RequestParam String input) {
        ModelAndView modelAndView = new ModelAndView("index");
        String result = dictService.find(input);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
