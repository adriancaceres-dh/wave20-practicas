package com.bootcamp.Covid_19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    String codigo;
    String nombre;
    String nivelDeGravedad;
}
