package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    public static List<CharacterDTO> getCharacters(){
        List<CharacterDTO> characters = new ArrayList<>();

        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Darth Vader");
        character1.setHeight(202);
        character1.setMass(136);
        character1.setHair_color("none");
        character1.setSkin_color("white");
        character1.setEye_color("yellow");
        character1.setBirth_year("41.9BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Maul");
        character2.setHeight(175);
        character2.setMass(80);
        character2.setHair_color("none");
        character2.setSkin_color("red");
        character2.setEye_color("yellow");
        character2.setBirth_year("54BBY");
        character2.setGender("male");
        character2.setHomeworld("Dathomir");
        character2.setSpecies("Zabrak");

        characters.add(character1);
        characters.add(character2);

        return characters;
    }
}
