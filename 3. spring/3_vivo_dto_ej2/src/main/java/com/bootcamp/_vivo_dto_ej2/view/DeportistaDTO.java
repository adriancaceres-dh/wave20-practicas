package com.bootcamp._vivo_dto_ej2.view;

import lombok.Getter;

@Getter
public class DeportistaDTO {

    private String nombre, apellido, nombreDeporte;

    public DeportistaDTO() {
    }

    public DeportistaDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }
}
