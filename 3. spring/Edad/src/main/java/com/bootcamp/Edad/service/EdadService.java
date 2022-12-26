package com.bootcamp.Edad.service;

import java.time.LocalDate;
import java.time.Period;

public class EdadService {
    public static int calcular(int dia, int mes, int año){
        LocalDate hoy = LocalDate.now();
        LocalDate fecha = LocalDate.of(año,mes,dia);
        Period period = Period.between(fecha,hoy);
        return period.getYears();
    }
}
