package com.example.edadPersona.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivel_de_gravedad;


}
