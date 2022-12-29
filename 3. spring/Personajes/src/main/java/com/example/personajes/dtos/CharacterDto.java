package com.example.personajes.dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CharacterDto {

    private String name;
    private int height;
    private double mass;
    private String gender;
    private String homeworld;
    private String species;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getMass() {
        return mass;
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
}
