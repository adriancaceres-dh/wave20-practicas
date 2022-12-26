package com.bootcamp._vivo_dto_ej2.view;


import lombok.Getter;

@Getter
public class DeporteDTO {

    String nombre,nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
