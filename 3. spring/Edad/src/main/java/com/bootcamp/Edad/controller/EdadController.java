package com.bootcamp.Edad.controller;

import com.bootcamp.Edad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{año}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año){
        return EdadService.calcular(dia,mes,año);
    }
}
