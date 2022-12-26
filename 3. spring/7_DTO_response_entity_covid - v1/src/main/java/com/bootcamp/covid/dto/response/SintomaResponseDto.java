package com.bootcamp.covid.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SintomaResponseDto {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;

}
