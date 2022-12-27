package com.bootcamp._multicapa_star_wars.service;

import com.bootcamp._multicapa_star_wars.dto.PersonajeDTO;
import com.bootcamp._multicapa_star_wars.model.PersonajeEntity;
import com.bootcamp._multicapa_star_wars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeDTOService {

    @Autowired
    PersonajeRepository repositorio;

    public List<PersonajeDTO> searchAllByName(String name){
        return repositorio.getAll().stream()
                .filter(personaje->personaje.getName().contains(name))
                .map(personaje->new PersonajeDTO(personaje.getName(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies(), personaje.getHeight(), personaje.getMass()))
                .collect(Collectors.toList());
    }

    public List<PersonajeDTO> searchAll(){
        return repositorio.getAll().stream()
                .map(personaje->new PersonajeDTO(personaje.getName(), personaje.getGender(), personaje.getHomeworld(), personaje.getSpecies(), personaje.getHeight(), personaje.getMass()))
                .collect(Collectors.toList());
    }

    public boolean addAll(List<PersonajeEntity> personajes){
        return repositorio.addAll(personajes);
    }

}
