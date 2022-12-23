package com.example.edadpersona.controllers;

import com.example.edadpersona.utils.AgeCalculatorUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @GetMapping(path = "/{day}/{month}/{year}")
    public int getCurrentAge(
            @PathVariable int day,
            @PathVariable int month,
            @PathVariable int year
    ) {
        return AgeCalculatorUtil.getCurrentAge(day, month, year);
    }
}
