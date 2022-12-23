package com.bootcamp.edad.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PersonaService {

    public int calcularEdad(int dia, int mes, int ano){
        LocalDate fHoy= LocalDate.now();
        LocalDate cumple= LocalDate.of(ano, mes, dia);
        long edad= ChronoUnit.YEARS.between(cumple, fHoy);
        return (int) edad;
    }
}
