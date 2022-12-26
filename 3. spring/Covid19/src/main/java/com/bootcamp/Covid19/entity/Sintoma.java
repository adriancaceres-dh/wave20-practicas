package com.bootcamp.Covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
public class Sintoma {

    private int codigo;
    private String nombre;
    private String nivelGravedad;
}
