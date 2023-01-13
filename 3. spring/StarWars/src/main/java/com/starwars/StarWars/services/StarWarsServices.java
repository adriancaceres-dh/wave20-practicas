package com.starwars.StarWars.services;


import com.starwars.StarWars.dto.PersonajeDTO;
import com.starwars.StarWars.repositories.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServices {

    @Autowired
    private StarWarsRepository starWarsRepository;

    public List<PersonajeDTO> encontrarPersonaje(String nombre){
        return starWarsRepository.loadDataBase().stream()
                .map(x-> new PersonajeDTO(x.getName(), x.getGender(), x.getHomeworld(), x.getSpecies(), x.getHeight(), x.getMass())).toList()
                .stream().filter(x-> x.getName().contains(nombre)).collect(Collectors.toList());
    }
}
