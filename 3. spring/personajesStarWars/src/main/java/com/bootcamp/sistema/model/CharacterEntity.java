package com.bootcamp.sistema.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterEntity {
    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;

    public CharacterEntity() {
    }

    public CharacterEntity(String name, String hair_color, String skin_color, String eye_color, String birth_year, String gender, String homeworld, String species, String height, String mass) {
        this.name = name;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

}
