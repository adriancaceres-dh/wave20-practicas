package com.bootcamp.codigomorse.codigomorse.controllers;

import com.bootcamp.codigomorse.codigomorse.models.CodigoMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {

    @GetMapping("/{codigo}")
    public String conversorAMorse(@PathVariable String codigo){
            return CodigoMorse.convertirMorse(codigo);
    }
}
