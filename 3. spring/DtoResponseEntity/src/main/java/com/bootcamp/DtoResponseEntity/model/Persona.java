package com.bootcamp.DtoResponseEntity.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomasList;

}
