package com.example.ejercicio_personajes_star_wars.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Personaje {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;


}
