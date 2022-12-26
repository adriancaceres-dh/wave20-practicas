package com.bootcamp._multicapa_star_wars.model;

import lombok.*;

@Data
public class PersonajeEntity {

    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private String height, mass;

}
