package com.example.ejercicio_personajes_star_wars.entity;

import com.example.ejercicio_personajes_star_wars.service.PersonaService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Personaje {

    public Personaje(){}

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;


}
