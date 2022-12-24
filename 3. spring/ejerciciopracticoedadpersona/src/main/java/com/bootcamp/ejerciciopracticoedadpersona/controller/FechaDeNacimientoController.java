package com.bootcamp.ejerciciopracticoedadpersona.controller;

import com.bootcamp.ejerciciopracticoedadpersona.service.FechaDeNacimientoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FechaDeNacimientoController {
    FechaDeNacimientoService fechaDeNacimientoService = new FechaDeNacimientoService();

    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return fechaDeNacimientoService.calcularEdad(dia, mes, anio);
    }
}
