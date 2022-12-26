package com.bootcamp.edades.service;

import java.time.LocalDate;
import java.time.Period;

public class EdadesService {

    public int getEdad (LocalDate fecha){
        LocalDate fechaActual = LocalDate.now();
        if (fecha != null && fechaActual != null){
            return Period.between(fecha,fechaActual).getYears();
        } else {
            return 0;
        }
    }

}
