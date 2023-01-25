package com.example.CrudConJpaEjPractico.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    String nombre;
    String material;
    int peso;
    String particularidad;
    boolean posee_piedra;
    boolean ventaONo;
}
