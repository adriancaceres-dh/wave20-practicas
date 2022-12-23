package com.bootcamp.prueba.controller;

import com.bootcamp.prueba.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public int calcularEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio ){
        return EdadService.calcularEdad(dia, mes, anio);
    }
}
