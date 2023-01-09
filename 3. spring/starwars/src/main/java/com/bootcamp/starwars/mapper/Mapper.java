package com.bootcamp.starwars.mapper;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.entity.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static Personaje mapToPersonaje(PersonajeDTO personajeDto) {
        Personaje personaje = Personaje.builder()
                .name(personajeDto.getName())
                .gender(personajeDto.getGender())
                .homeworld(personajeDto.getHomeworld())
                .species(personajeDto.getSpecies())
                .height(personajeDto.getHeight())
                .mass(personajeDto.getMass())
                .build();

        return personaje;
    }

    public static PersonajeDTO mapToPersonajeDto(Personaje personaje) {
        return PersonajeDTO.builder()
                .name(personaje.getName())
                .gender(personaje.getGender())
                .homeworld(personaje.getHomeworld())
                .species(personaje.getSpecies())
                .height(personaje.getHeight())
                .mass(personaje.getMass())
                .build();
    }

    public static List<Personaje> mapToListPersonaje(List<PersonajeDTO> personajesDto) {
        List<Personaje> personajes = new ArrayList<>();
        personajesDto.stream().map(p -> personajes.add(mapToPersonaje(p)));
        return personajes;
    }

    public static List<PersonajeDTO> mapToListPersonajeDto(List<Personaje> personajes) {
        List<PersonajeDTO> personajesDto = new ArrayList<>();
        personajes.stream().map(p -> (mapToPersonajeDto(p)));
        System.out.println("personajesDto metodo mapToListPersonajeDto= " + personajesDto);
        return personajes.stream().map(w -> mapToPersonajeDto(w)).collect(Collectors.toList());
    }
}
