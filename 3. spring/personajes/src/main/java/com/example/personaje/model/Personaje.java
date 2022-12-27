package com.example.personaje.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@AllArgsConstructor
@Data
public class Personaje {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
    @JsonIgnore
    private String hair_color;
    @JsonIgnore
    private String skin_color;
    @JsonIgnore
    private String eye_color;
    @JsonIgnore
    private String birth_year;
    public Personaje() {
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                '}';
    }
}
