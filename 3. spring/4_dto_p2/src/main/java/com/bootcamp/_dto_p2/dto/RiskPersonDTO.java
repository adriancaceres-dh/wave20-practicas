package com.bootcamp._dto_p2.dto;

import lombok.Getter;

@Getter
public class RiskPersonDTO {

    private String nombre, apellido;

    public RiskPersonDTO(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    @Override
    public String toString() {
        return "RiskPersonDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
