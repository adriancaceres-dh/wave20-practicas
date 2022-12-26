package com.bootcamp.star_wars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class PersonajeDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeWorld;
    private String species;
}
