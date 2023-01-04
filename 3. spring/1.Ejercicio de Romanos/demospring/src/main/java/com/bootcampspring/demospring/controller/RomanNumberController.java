package com.bootcampspring.demospring.controller;

import com.bootcampspring.demospring.service.RomanNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumberController {
    @GetMapping(value = "/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return "Hello " + name + " <3";
    }

    @GetMapping(value = "/arabic-to-roman/{number}")
    public String greeting(@PathVariable Integer number) {
        RomanNumberService romanNumberService = new RomanNumberService();
        return romanNumberService.romanNumber(number);
    }
}
