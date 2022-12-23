package com.bootcamp.edadconfecha.service;

import com.bootcamp.edadconfecha.model.FechaModel;

import java.time.LocalDate;
import java.time.Period;

public class FechaService {

    public String fechaAEdad(String dia, String mes, String ano){
        FechaModel fechaUsuario = new FechaModel(dia,mes,ano);

        LocalDate fechaUsuarioLocalDate = fechaUsuario.getAsDate();
        LocalDate curDate = LocalDate.now();

        String edad = String.valueOf(Period.between(fechaUsuarioLocalDate, curDate).getYears());

        return "La edad de la persona con fecha de nacimiento "+fechaUsuario.toString()+" es " +edad;
    }

}
