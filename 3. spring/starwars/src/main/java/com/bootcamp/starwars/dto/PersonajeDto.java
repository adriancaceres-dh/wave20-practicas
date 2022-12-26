package com.bootcamp.starwars.dto;

import com.bootcamp.starwars.entity.Personaje;
import lombok.Getter;

@Getter
public class PersonajeDto {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDto(Personaje personaje) {
        name = personaje.getName();
        height = personaje.getHeight();
        mass = personaje.getMass();
        gender = personaje.getGender();
        homeworld = personaje.getHomeworld();
        species = personaje.getSpecies();
    }
}
