package com.edadpersona.EdadPersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadDeUnaPersona {
    @GetMapping("/edad/{dia}/{mes}/{a}")
    public int calcularEdad(@PathVariable int dia,
                            @PathVariable int mes,
                            @PathVariable int a){
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = LocalDate.of(a,mes,dia);
        Period edad = Period.between(nacimiento,hoy);
        return edad.getYears();
    }
}
