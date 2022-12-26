package com.bootcamp.codigomorse.controller;

import com.bootcamp.codigomorse.model.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseAPI {

    CodigoMorse codigoMorse = new CodigoMorse();

    @GetMapping("{codigo}")
    public String convertirMorse(@PathVariable("codigo") String codigo){
        return codigoMorse.decodificar(codigo);
    }

}
