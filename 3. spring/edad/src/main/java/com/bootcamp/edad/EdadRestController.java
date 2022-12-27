package com.bootcamp.edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadRestController {

    @GetMapping("/{dia}/{mes}/{anio}")

    public int devolverEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);

        Period edad = Period.between(fechaNacimiento, LocalDate.now());

        return edad.getYears();

    }

}
