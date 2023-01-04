package com.bootcamp.prueba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Roma {

    @GetMapping("/roma/{numero}")
    public String romanTransform(@PathVariable int numero) {
        if (numero == 0) return "Escribir numero para comnenzar";
        int numeroOriginal = numero;
        int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] letrasRomanas = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder roman = new StringBuilder();
        for(int i=0; i < valores.length; i++)
        {
            while(numero >= valores[i])
            {
                numero = numero - valores[i];
                roman.append(letrasRomanas[i]);
            }
        }
        return "El numero romano correspondiente a " + numeroOriginal + " es: " + roman;
    }
}
