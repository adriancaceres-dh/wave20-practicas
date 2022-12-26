package com.bootcamp.starwars.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDTO {
    private String name;
    @JsonProperty ("hair_color")
    private String hair_color;
    @JsonProperty ("skin_color")
    private String skin_color;
    @JsonProperty ("eye_color")
    private String eye_color;
    @JsonProperty ("birth_year")
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
    private String height;
    private String mass;


    public CharacterDTO() {
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
