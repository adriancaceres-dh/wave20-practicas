package com.bootcamp.edad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio ){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return ResponseEntity.ok().body("Edad: " + edad);
    }
}
