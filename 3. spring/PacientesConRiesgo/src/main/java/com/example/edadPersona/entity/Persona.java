package com.example.edadPersona.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Set<String> sintomas;


}
