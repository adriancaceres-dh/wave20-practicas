package com.numerosromanos.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{numero}")
    public String convertirARomano(@PathVariable int numero){
        StringBuilder ans = new StringBuilder();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<values.length;i++)
        {
            while(numero >= values[i])
            {
                numero = numero - values[i];
                ans.append(romanLetters[i]);
            }
        }

        return ans.toString();
    }
}
