package com.example.ejercicio_personajes_star_wars.service;

import com.example.ejercicio_personajes_star_wars.Repository.PersonaRepository;
import com.example.ejercicio_personajes_star_wars.dto.response.PersonajeResponseDto;
import com.example.ejercicio_personajes_star_wars.entity.Personaje;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonajeResponseDto> findByName(String name){
        ModelMapper modelMapper = new ModelMapper();
        //return personaRepository.findByName(name).stream().
        //        map(e -> modelMapper.map(e, PersonajeResponseDto.class)).
        //       collect(Collectors.toList());

        return personaRepository.findByName(name).stream().
                map(e -> {
                    PersonajeResponseDto personajeResponseDto = new PersonajeResponseDto(
                            e.getName(),
                            e.getHeight(),
                            e.getMass(),
                            e.getGender(),
                            e.getHomeworld(),
                            e.getSpecies()
                    );
                    return personajeResponseDto;
                }).
                collect(Collectors.toList());
    }
}
