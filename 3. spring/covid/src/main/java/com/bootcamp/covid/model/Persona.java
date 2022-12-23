package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Persona implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}
