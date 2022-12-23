package com.bootcamp.EdadPersona.colector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class CalcularEdad {
    @GetMapping("/calcularEdad/{dia}/{mes}/{age}")
    public String edad(@PathVariable String dia,
                    @PathVariable String mes,
                    @PathVariable String age){



        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nacio = dia+"/"+mes+"/"+age;
        LocalDate fechaNac = LocalDate.parse(nacio, fmt);

        Period edad = Period.between(fechaNac,fechaActual);


        return String.valueOf(edad.getYears());

    }

}
