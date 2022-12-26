package com.bootcamp.DtoResponseEntity.model;

import lombok.*;

import java.util.List;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;

}
