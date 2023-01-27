package com.example.JPA_2601.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothDTO {
    private Integer codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;
    private Integer talle;

    private Integer cantidad;
    private Double precioVenta;
}
