package com.bootcamp.springdtop1deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private Nivel nivel;
}
