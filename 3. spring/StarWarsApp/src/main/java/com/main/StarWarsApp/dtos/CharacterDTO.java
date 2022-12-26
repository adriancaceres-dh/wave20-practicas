package com.main.StarWarsApp.dtos;

import lombok.Data;

@Data
public class CharacterDTO {
        private String name;
        private String hair_color;
        private String skin_color;
        private String eye_color;
        private String birth_year;
        private String gender;
        private String homeworld;
        private String species;
        private String height;
        private String mass;
}
