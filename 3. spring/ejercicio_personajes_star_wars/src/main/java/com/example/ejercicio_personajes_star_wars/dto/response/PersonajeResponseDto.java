package com.example.ejercicio_personajes_star_wars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PersonajeResponseDto {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
