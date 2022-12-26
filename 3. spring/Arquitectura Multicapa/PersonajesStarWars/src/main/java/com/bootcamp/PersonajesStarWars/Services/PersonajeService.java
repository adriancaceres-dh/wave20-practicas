package com.bootcamp.PersonajesStarWars.Services;

import com.bootcamp.PersonajesStarWars.DTO.PersonajesDto;
import com.bootcamp.PersonajesStarWars.Models.Personajes;
import com.bootcamp.PersonajesStarWars.Respository.PersonajeRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    PersonajeRespositorio personajes;

    @Override
    public List<PersonajesDto> PersonajeEncontrarSegunNombre(String nombreEncontrar) {
        List<Personajes> personajesDeBD = personajes.getPersonajesEnBD();
        List<PersonajesDto> personajesDevolver = new LinkedList<>();

        for (Personajes p : personajesDeBD) {
            if(p.getName().contains(nombreEncontrar)){
                personajesDevolver.add(new PersonajesDto(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeWorld(),p.getSpecies()));
            }
        }
        return personajesDevolver;
    }
}
