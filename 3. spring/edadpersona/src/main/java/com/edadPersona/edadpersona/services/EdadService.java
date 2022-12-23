package com.edadPersona.edadpersona.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EdadService {

    public static String calcularEdadPersona(String dia, String mes, String ano){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(dia + "/" + mes + "/" + ano, formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        return String.format("%d años, %d meses y %d días",
                edad.getYears(),
                edad.getMonths(),
                edad.getDays());
    }
}

