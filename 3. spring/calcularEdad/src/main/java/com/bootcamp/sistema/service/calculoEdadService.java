package com.bootcamp.sistema.service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class calculoEdadService {

    public static long calcularEdad(int dia, int mes, int anio) {
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);

        //long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        //return edad;

        Period periodo = Period.between(nacimiento, hoy);

        return periodo.getYears();
    }

}
