package com.bootcamp.numerosromanos.controllers;


import com.bootcamp.numerosromanos.services.NumerosRomanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {


    @Autowired
    private NumerosRomanosService numerosRomanosService;



    @GetMapping("{numero}")
    public String obteberNumero(@PathVariable int numero){

        String respuesta = numerosRomanosService.getNumeroRomano(numero);

        return respuesta;
    }

}
