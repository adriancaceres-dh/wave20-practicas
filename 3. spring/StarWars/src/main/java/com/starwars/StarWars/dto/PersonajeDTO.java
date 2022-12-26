package com.starwars.StarWars.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PersonajeDTO {

    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;
}
