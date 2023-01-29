package com.example.productos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {
    private String id;
    private String nombre;
    private String tipo;
    private String precioVenta;
    private String precioCosto;
    private String cantidad;
}
