package com.example.ejercicioedad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class ControllerEdad {

  @GetMapping("/{dia}/{mes}/{anio}")
  public ResponseEntity<String> edad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
    LocalDate ahora = LocalDate.now();
    Period period = Period.between(fechaNacimiento, ahora);
    return new ResponseEntity<>("Tu edad es: " + period.getYears(), HttpStatus.OK);
  }
}
