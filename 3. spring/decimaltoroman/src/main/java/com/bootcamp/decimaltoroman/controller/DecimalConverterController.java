package com.bootcamp.decimaltoroman.controller;

import com.bootcamp.decimaltoroman.model.DecimalToRomanConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecimalConverterController {
    @GetMapping("/{number}")
    public String getConvertedNumber(@PathVariable int number) {
        return DecimalToRomanConverter.convert(number);
    }
}
