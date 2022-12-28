package com.mercadolibre.numeros_romanos.controller;

import com.mercadolibre.numeros_romanos.service.NumerosRomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{decimal}")
    public String sayHello(@PathVariable int decimal) {
        return NumerosRomanosService.toRoman(decimal);
    }
}
