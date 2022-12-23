package com.bootcamp.edad.controller;

import com.bootcamp.edad.model.AgeCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AgeController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public long getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return AgeCalculator.calculateAge(LocalDate.of(anio, mes, dia));
    }

}
