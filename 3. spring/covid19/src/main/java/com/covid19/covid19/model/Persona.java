package com.covid19.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    String id;
    String nombre;
    String apellido;
    Integer edad;
    List<Sintoma> sintomas;
}
