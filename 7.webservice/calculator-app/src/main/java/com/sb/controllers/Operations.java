package com.sb.one.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Operations {

    @GetMapping("/")
    public String home() {
        return "HOME PAGE";
    }

    @GetMapping("/add")
    public String add(@RequestParam double a, @RequestParam double b) {
        return "Addition of " + a + " + " + b + " = " + (a + b);
    }

    @GetMapping("/sub")
    public String sub(@RequestParam double a, @RequestParam double b) {
        return "Subtraction of " + a + " - " + b + " = " + (a - b);
    }

    @GetMapping("/mul")
    public String mul(@RequestParam double a, @RequestParam double b) {
        return "Multiplication of " + a + " * " + b + " = " + (a * b);
    }

    @GetMapping("/div")
    public String div(@RequestParam double a, @RequestParam double b) {
        if (b == 0) return "Cannot divide by zero!";
        return "Division of " + a + " / " + b + " = " + (a / b);
    }
}
