package com.example.edadpersona;

import com.example.edadpersona.excepciones.InvalidDateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@RestController

public class Persona {
    @GetMapping("/{day}/{month}/{year}")
    public long CalcEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        try
        {
            LocalDateTime fechaNac = LocalDateTime.of(year,month,day,0,0);
            LocalDateTime tenSecondsLater = LocalDateTime.now();
            return ChronoUnit.YEARS.between(fechaNac, tenSecondsLater);

        }catch (DateTimeException e){
            throw new InvalidDateException("La fecha "+ day+"/"+month+"/"+year + " no es valida");
        }

    }
}
