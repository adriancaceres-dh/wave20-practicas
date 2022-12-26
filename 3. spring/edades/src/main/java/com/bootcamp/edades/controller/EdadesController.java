package com.bootcamp.edades.controller;

import com.bootcamp.edades.service.EdadesService;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class EdadesController {

    EdadesService edadesService = new EdadesService();

    @GetMapping("{dia}/{mes}/{anio}")
    public int getEdad (@PathVariable String dia , @PathVariable String mes , @PathVariable String anio){
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate fecha = LocalDate.parse(anio+mes+dia, formatter);
        return edadesService.getEdad(fecha);
    }

}
