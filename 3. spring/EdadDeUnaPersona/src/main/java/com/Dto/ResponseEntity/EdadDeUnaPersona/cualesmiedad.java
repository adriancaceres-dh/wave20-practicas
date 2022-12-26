package com.Dto.ResponseEntity.EdadDeUnaPersona;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class cualesmiedad {

    @GetMapping("/{dia}/{mes}/{anio}")
    ResponseEntity<String> obtenerEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio)
    {
        Period edad = this.calcularEdad(dia, mes, anio);

        return ResponseEntity.ok("-> Date: " + dia + "/" + mes + "/" + anio + " - Edad: " + edad.getYears());
    }

    public Period calcularEdad(int dia, int mes, int anio)
    {
        return Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
    }
}
