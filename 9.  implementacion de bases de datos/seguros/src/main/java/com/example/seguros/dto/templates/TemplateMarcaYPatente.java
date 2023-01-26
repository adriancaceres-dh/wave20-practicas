package com.example.seguros.dto.templates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class TemplateMarcaYPatente {
    private long patente;
    private String marca;
}
