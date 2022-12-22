package com.bootcamp.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/{numero}")
    public String conversorDeEnteros(@PathVariable Integer numero) {
        int[] valores = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] letrasRomanas = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String romano = "";
        for(int i=0;i<valores.length;i++) {
            while(numero >= valores[i]) {
                numero = numero - valores[i];
                romano += (letrasRomanas[i]);
            }
        }
        return romano;

    }
}
