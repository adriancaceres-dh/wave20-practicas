package com.bootcamp.Covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO {
    private String nombre;
    private String nivel_de_gravedad;
}
