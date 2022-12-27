package com.bootcamp.StarWars.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcamp.StarWars.DTOs.PersonajeDTO;
import com.bootcamp.StarWars.models.Personaje;
import com.bootcamp.StarWars.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<PersonajeDTO> obtenerPersonajes(){
        List<Personaje> listapersonajes = personajeRepository.obtenerListadoPersonajes();
        List<PersonajeDTO> listadoenvio = new ArrayList<>();
        listapersonajes.stream().forEach(p -> {listadoenvio.add(new PersonajeDTO(p.getName(),p.getHeight(),p.getMass(), p.getGender(),p.getHomeworld(),p.getSpecies()));});

        return listadoenvio;
    }

    public List<PersonajeDTO> obtenerPersonajesPorNombre(String texto){
        List<Personaje> listapersonajes = personajeRepository.busquedaPersonajes(texto);
        List<PersonajeDTO> listadoenvio = new ArrayList<>();

        listapersonajes.stream().forEach(p -> {listadoenvio.add(new PersonajeDTO(p.getName(),p.getHeight(),p.getMass(), p.getGender(),p.getHomeworld(),p.getSpecies()));});

        return listadoenvio;
    }
}
