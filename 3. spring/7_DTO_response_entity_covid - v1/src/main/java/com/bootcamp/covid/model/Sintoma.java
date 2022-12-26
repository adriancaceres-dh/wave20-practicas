package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
