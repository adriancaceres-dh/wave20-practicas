package com.bootcamp.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {
    private String name;

    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;
}
