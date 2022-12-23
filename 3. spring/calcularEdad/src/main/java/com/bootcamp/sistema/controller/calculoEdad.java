package com.bootcamp.sistema.controller;

import com.bootcamp.sistema.service.calculoEdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calculoEdad {
    @GetMapping("/{dia}/{mes}/{anio}")
    public long calculoEdad(
            @PathVariable int dia,
            @PathVariable int mes,
            @PathVariable int anio
    ) {
        return calculoEdadService.calcularEdad(dia, mes, anio);
        //luego se agregarian las validaciones correspondientes en caso de ingresar numeros no correspondientes a fechas validas
    }
}
