package com.bootcamp.fechas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDate.now;

@RestController
public class Fechas {

    @GetMapping("/")
    public String saludar () {
        return "Ingresa tu fecha de nacimiento en la URI con formato dia/mes/año.";
    }

    @GetMapping("/{dd}/{mm}/{yy}/")
    public String devolverEdad (@PathVariable Integer dd, @PathVariable Integer mm, @PathVariable Integer yy) {
        int anios = now().getYear() - yy;

        if (anios < 0) return "Por favor ingresar una fecha válida.";

        if (mm < now().getMonthValue() || (mm == now().getMonthValue() && dd <= now().getDayOfMonth())) {
            anios ++;
        }

        return "Usted tiene: " + anios + " años.";
    }
}
