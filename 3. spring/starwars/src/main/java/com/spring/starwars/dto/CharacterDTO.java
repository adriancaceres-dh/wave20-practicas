package com.spring.starwars.dto;

import lombok.Data;

@Data
public class CharacterDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
