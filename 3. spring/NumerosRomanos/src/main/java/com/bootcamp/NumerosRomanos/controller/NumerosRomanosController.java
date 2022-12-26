package com.bootcamp.NumerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String romano(@PathVariable Integer numero){
        
        StringBuilder numerosRomanos = new StringBuilder();
        
        int[] numeros = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanos = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numeros.length; i++) {
            while (numero >= numeros[i]){
                numero -= numeros[i];
                numerosRomanos.append(romanos[i]);
            }
        }
        return numerosRomanos.toString();
    }


}
