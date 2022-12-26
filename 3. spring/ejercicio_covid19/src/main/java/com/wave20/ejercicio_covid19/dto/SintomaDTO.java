package com.wave20.ejercicio_covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SintomaDTO {

    private int codigo;
    private String nombre;
    private String nivel_gravedad;

    public SintomaDTO() {

    }


}
