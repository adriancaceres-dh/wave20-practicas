package com.bootcamp.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterDtoResponse {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
