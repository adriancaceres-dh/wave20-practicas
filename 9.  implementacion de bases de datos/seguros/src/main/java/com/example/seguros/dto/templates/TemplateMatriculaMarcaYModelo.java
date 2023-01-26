package com.example.seguros.dto.templates;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
public class TemplateMatriculaMarcaYModelo {
    private long patente;
    private String marca;
    private String model;
}
