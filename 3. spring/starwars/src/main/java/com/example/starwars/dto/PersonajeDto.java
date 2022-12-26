package com.example.starwars.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {
    private  String name;
    private  float height;
    private  float mass;
    private  String gender;
    private  String homeWorld;
    private  String species;
}
