package com.bootcamp.DtoResponseEntity.dto;

import com.bootcamp.DtoResponseEntity.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@AllArgsConstructor
@Getter
@Setter
public class SintomaDTO {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
}
