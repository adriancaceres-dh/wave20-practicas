package com.example.starwars.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonajeDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeWorld;
    private String species;
}