package com.bootcamp.numerosromanos.controllers;

import com.bootcamp.numerosromanos.utils.NumberConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    @GetMapping("/{romanian}")
    public Integer getNumberFromRomanian(@PathVariable String romanian) {
        return NumberConverter.transformRomanianToInteger(romanian);
    }
}
