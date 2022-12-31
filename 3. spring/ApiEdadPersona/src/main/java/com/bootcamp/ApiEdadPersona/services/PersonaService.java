package com.bootcamp.ApiEdadPersona.services;

import java.time.LocalDate;
import java.time.Period;

public class PersonaService {

    public static int getEdad(int dia, int mes, int ano){
        Period edad;
        edad = Period.between(LocalDate.of(ano,mes, dia), LocalDate.now());

        return edad.getYears();
    }
}
