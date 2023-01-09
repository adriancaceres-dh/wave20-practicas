package com.bootcamp.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonajeDTO {
    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;

}
