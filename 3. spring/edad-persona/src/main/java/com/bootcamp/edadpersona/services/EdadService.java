package com.bootcamp.edadpersona.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Date;

@Service
public class EdadService {



    // Método que calcula una edad por medio una fecha
    public int getEdad(int diaNacimiento, int mesNacimiento, int annoNacimiento){

        int edadPersona = 0;

        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int diaAcutal = fechaActual.getDayOfMonth();

        edadPersona = fechaActual.getYear() - annoNacimiento;

        if (mesActual < mesNacimiento) {
            edadPersona = edadPersona - 1;

        } else if (mesActual == mesNacimiento) {
            if (diaAcutal < diaNacimiento) {
                edadPersona = edadPersona - 1;
            }

        }

        return  edadPersona;
    }
}
