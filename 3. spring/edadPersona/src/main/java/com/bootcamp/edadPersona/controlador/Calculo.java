package com.bootcamp.edadPersona.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
public class Calculo {
    @GetMapping("/nacimmiento/{dia}/{mes}/{ano}")
    public int calculoEdad(@PathVariable String dia,@PathVariable String mes,@PathVariable String ano){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoText = dia+"/"+mes+"/"+ano;
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoText, formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
       // System.out.println(String.format("%d años, %d meses y %d días",
               // edad.getYears(),
                //edad.getMonths(),
                //edad.getDays()));
        return edad.getYears();
    }
}
