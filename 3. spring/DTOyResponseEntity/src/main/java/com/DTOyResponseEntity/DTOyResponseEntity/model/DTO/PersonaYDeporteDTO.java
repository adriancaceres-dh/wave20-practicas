package com.DTOyResponseEntity.DTOyResponseEntity.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class PersonaYDeporteDTO implements Serializable {
    String nombre;
    String apellido;
    String nombreDeporte;
}
