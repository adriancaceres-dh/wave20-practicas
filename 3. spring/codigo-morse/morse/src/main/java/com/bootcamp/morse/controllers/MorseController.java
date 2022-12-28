package com.bootcamp.morse.controllers;

import com.bootcamp.morse.services.CodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    // Atributos
    @Autowired
    private CodigoService codigoService;


    // Buscar un caracter por su codigo morse
    @GetMapping("/{code}")
    public String decodificarMorse(@PathVariable String code ){
        return codigoService.getCodigo(code);

    }


}
