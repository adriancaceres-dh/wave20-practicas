package com.HelloRestControllerrr.PruebaApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class HelloRestController {
    @GetMapping(path = "{dia}/{mes}/{anio}")
    public String sayHello(@PathVariable Integer dia,
                           @PathVariable Integer mes,
                           @PathVariable Integer anio){
        LocalDate date = LocalDate.now();
        LocalDate birthDate = LocalDate.of(anio, dia, mes);
        Period diff = Period.between(birthDate, date);
        return ("Usted tiene  " + diff.getYears() + " años");
    }
}
