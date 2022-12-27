package com.example.personaje.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Builder
@AllArgsConstructor
@Data
public class PersonajeDto {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDto() {
    }

    @Override
    public String toString() {
        return "PersonajeDto{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
