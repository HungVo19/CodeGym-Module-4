package com.example.customer_manager.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HandleError implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        return null;
    }
}
