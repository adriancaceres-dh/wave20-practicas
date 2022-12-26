package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.model.Personaje;
import com.bootcamp.starwars.repository.IPersonajeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{

    @Autowired
    private IPersonajeRepository personajeRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PersonajeService(){
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public Personaje getPersonaje() {
        return null;
    }

    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) {
        try {
            List<Personaje> personajes = personajeRepository.getPersonajesByName(name);
            List<PersonajeDTO> personajesDTO = personajes.stream().map(personaje -> mapper.map(personaje,PersonajeDTO.class)).collect(Collectors.toList());
            return personajesDTO;
        } catch (Exception e){
            System.out.println("Error. Exception: "+e.getMessage());
        }
        return null;
    }
}
