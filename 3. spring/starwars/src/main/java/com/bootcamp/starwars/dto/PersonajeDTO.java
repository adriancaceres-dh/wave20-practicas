package com.bootcamp.starwars.dto;

import com.bootcamp.starwars.model.Personaje;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDTO {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO (Personaje personaje) {

        this.name=personaje.getName();
        this.height=personaje.getHeight();
        this.mass=personaje.getMass();
        this.gender=personaje.getGender();
        this.homeworld=personaje.getHomeworld();
        this.species=personaje.getSpecies();

    }


}
