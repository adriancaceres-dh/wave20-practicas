package com.bootcamp._multicapa_star_wars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonajeDTO {

    private String name, gender, homeworld, species;
    private String height, mass;

}
