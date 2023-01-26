package com.bootcamp.seguros.model.templates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteYMarca {
    private String patente;
    private String marca;
}
