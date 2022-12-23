package com.bootcamp.fechanacimiento.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.bootcamp.fechanacimiento.service.FechanacimientoService.calcularFecha;

@RestController
public class FechanacimientoController {
    @GetMapping("/{dia}/{mes}/{anno}")
    public int darFecha(@PathVariable String dia, @PathVariable String mes, @PathVariable String anno) {
        return calcularFecha(dia,mes,anno);
    }
}
