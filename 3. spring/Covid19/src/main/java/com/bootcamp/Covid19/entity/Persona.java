package com.bootcamp.Covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
