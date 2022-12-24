package com.bootcamp.Aplicacion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraCumpleaños {

    //Conviene siempre pedir String y despues castearlo?
    @GetMapping(path="/calcularEdad/{dia}/{mes}/{anio}")
    public String  calcularEdad(@PathVariable int dia,
                             @PathVariable int mes,
                             @PathVariable int anio){

        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        return " "  + edad.getYears();
    }

}