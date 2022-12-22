package com.example.numerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero){
        return NumerosRomanos.convertirNumero(numero);
    }
}
