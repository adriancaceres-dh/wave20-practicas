package com.bootcamp.starwars.dto.response;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonajeDTO{

    String name;
    String height;
    String mass;
    String gender;
    String homeworld;
    String species;
}
