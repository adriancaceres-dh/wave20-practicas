package com.example.edadpersona.service;

import com.example.edadpersona.model.Persona;

import java.time.LocalDate;

public class EdadPersona {

    public static int calcular(Persona persona){
        LocalDate fechaActual=LocalDate.now();
        int difYear=fechaActual.getYear()-persona.getYear();
        int difMes= fechaActual.getMonthValue()-persona.getMonth();
        int difdia= fechaActual.getDayOfMonth()-persona.getDay();

        int edad=difYear;

        if(difMes<0) return --edad;
        else if (difMes==0) {
            if (difdia<0) return --edad;
        }

        return edad;
    }
}
