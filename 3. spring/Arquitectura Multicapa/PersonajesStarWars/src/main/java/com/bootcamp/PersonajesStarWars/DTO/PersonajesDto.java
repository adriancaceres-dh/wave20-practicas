package com.bootcamp.PersonajesStarWars.DTO;

public class PersonajesDto {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;

    public PersonajesDto(String name, int height, int mass, String gender, String homeWorld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public String getSpecies() {
        return species;
    }
}
