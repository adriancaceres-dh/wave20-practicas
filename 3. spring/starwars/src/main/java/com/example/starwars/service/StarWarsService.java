package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.entity.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsService {
    List<Character> characters;

    public StarWarsService() {
        this.characters = new ArrayList<>();
        Character char1=new Character("dark vader",168,71,
                "blue","clear","blue","1002","male"
        ,"mars","reptil");

        Character char2=new Character("Luke skywalker",168,71,
            "blue","clear","blue","1002","male"
            ,"mars","reptil");

        Character char3=new Character("leia organa",168,71,
                "blue","clear","blue","1002","male"
                ,"mars","s");
        Character char4=new Character("han solo",168,71,
                "blue","clear","blue","1002","male"
                ,"mars","reptil");
        Character char5=new Character("baby yoda",168,71,
                "blue","clear","blue","1002","male"
                ,"mars","reptil");

        characters.add(char1);
        characters.add(char2);
        characters.add(char3);
        characters.add(char4);
        characters.add(char5);
    }

    public List<CharacterDTO> consulta(String name){
        List<Character> search=characters.stream().filter(c->c.getName().toLowerCase()
                .contains(name.toLowerCase())).collect(Collectors.toList());
        if(search.isEmpty()) return null;

        return search.stream().map(c->new CharacterDTO(c.getName(),
                c.getHeight(),c.getMass(),c.getGender(),
                c.getHomeworld(),c.getSpecies())).collect(Collectors.toList());
    }
}
