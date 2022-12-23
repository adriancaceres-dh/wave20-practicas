package com.bootcamp.edadpersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class PersonaController {
    @GetMapping("/{day}/{month}/{year}")
    public int calcularEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate fechaNacimiento = LocalDate.of(year,month,day);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }


}
