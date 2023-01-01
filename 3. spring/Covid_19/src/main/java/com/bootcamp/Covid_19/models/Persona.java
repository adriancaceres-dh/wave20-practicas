package com.bootcamp.Covid_19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    String id;
    String nombre;
    String apellido;
    int edad;
    List<Sintoma> sintomas;


}
