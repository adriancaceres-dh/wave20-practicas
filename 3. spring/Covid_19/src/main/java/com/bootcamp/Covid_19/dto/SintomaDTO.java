package com.bootcamp.Covid_19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaDTO {

    String codigo;
    String nombre;
    String nivelDeGravedad;
}
