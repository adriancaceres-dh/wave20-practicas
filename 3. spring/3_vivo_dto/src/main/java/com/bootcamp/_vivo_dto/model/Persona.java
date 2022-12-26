package com.bootcamp._vivo_dto.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Persona {

    private Date fechaNacimiento;

    public Persona(int diaNacimiento, int mesNacimiento, int anioNacimiento) {
        this.fechaNacimiento= new Date(anioNacimiento,mesNacimiento,diaNacimiento);
    }

    public static int calcularEdad(int diaNacimiento, int mesNacimiento, int anioNacimiento){
        int edad= LocalDateTime.now().getYear()-anioNacimiento-1;
        if(LocalDateTime.now().getMonthValue() - mesNacimiento >=0 && LocalDateTime.now().getDayOfMonth()-diaNacimiento >=0){
            edad+=1;
        }
        return edad;
    }
}
