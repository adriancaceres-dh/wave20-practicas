package com.starwars.starwarsCharacters.dtoresponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharactersDtoResponse {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
