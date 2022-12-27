package com.bootcamp.StarWars.DTOs;

public class PersonajeDTO {

    final String name, gender, homeworld, species, height, mass;

    public PersonajeDTO(String name, String height, String mass,  String gender, String homeworld, String species) {
        this.name = name;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
        this.height = height;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }
}
