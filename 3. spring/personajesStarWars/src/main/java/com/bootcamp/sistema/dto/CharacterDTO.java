package com.bootcamp.sistema.dto;

public class CharacterDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;

    public CharacterDTO() {
    }

    public CharacterDTO(String name, String gender, String homeworld, String species, String height, String mass) {
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

