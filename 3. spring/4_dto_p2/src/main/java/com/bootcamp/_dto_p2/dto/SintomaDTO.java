package com.bootcamp._dto_p2.dto;

import lombok.Getter;

@Getter
public class SintomaDTO {

    private String codigo, nombre, nivel_de_gravedad;

    public SintomaDTO(String codigo, String nombre, String nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
