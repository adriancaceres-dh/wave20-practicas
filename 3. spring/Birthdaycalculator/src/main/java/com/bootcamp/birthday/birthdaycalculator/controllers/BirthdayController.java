package com.bootcamp.birthday.birthdaycalculator.controllers;

import com.bootcamp.birthday.birthdaycalculator.services.Calculate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirthdayController {

    @GetMapping("/{day}/{month}/{year}")
    public String getBirthDay(@PathVariable int day, @PathVariable int month,@PathVariable int year){
        String age = Calculate.Calculate(year+"-"+month+"-"+day);
        return "<h2 style=>"+age+"</h2>";
    }
}
