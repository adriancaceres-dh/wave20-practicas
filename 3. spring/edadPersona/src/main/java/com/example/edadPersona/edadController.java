package com.example.edadPersona;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
@RequestMapping()
public class edadController {
    @GetMapping("/{dia}/{mes}/{ano}")
    public int calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }
}
