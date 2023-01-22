package com.deportistas.deportistas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaPersonasYDeportesDto {

    private String nombre;
    private String apellido;
    private String deportePersona;
}
