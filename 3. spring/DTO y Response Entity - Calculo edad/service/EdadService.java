package com.bootcamp.prueba.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadService {

    public static int calcularEdad(int dia, int mes, int anio) {
        String fechaNacimiento = dia + "/" + mes + "/" + anio;

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);

        Period edad = Period.between(fechaNac,fechaActual);

        return edad.getYears();
    }
}
