package com.example.productos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {
    private String nombre;
    private String tipo;
    private String precioVenta;
    private String precioCosto;
    private String cantidad;
}
