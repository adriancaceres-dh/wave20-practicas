package com.bootcamp.star_wars.service;

import com.bootcamp.star_wars.dto.PersonajeDTO;
import com.bootcamp.star_wars.model.Personaje;
import com.bootcamp.star_wars.repository.PersonajeRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    private PersonajeRepositoryImpl personajeRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<PersonajeDTO> obtenerPersonajesPorNombre(String nombre) {
        List<Personaje> personajes = personajeRepository.obtenerPersonajes();

        personajes = personajes.stream()
                .filter(personaje -> personaje.getName().toLowerCase(Locale.ROOT).contains(nombre.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());

        return personajes.stream().map(personaje -> mapper.map(personaje, PersonajeDTO.class)).collect(Collectors.toList());
    }
}
