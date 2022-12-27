package com.bootcamp.Starwars.DTO;

import lombok.Builder;

@Builder
public class CharacterDTO {
    String name, gender,homeworld,species;
    int height, mass;

    public CharacterDTO(String name, String gender, String homeworld, String species, int height, int mass) {
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

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

}
