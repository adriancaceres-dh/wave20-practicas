package com.bootcamp.springdtop1deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private String nombreApellido;
    private int edad;
    private Deporte deporte;
}
