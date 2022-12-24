package com.bootcamp.Deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Persona {
    private String nombre;
    private String apellido;

    private int edad;

}
