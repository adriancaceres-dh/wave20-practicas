package com.covid19.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    String codigo;
    String nombre;
    String nivel_de_gravedad;
}
