package com.bootcamp.ejerciciopracticoedadpersona.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FechaDeNacimientoService {

    //Calcular edad
    public String calcularEdad(int dia, int mes, int anio) {
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return (String.format("%d años, %d meses y %d días",
                edad.getYears(),
                edad.getMonths(),
                edad.getDays()));
    }
}
