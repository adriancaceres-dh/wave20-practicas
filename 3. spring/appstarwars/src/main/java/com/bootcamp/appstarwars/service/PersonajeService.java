package com.bootcamp.appstarwars.service;

import com.bootcamp.appstarwars.dto.PersonajeDto;
import com.bootcamp.appstarwars.models.Personaje;
import com.bootcamp.appstarwars.repository.IPersonajeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {
    @Autowired
    private IPersonajeRepository personajeRepository;
    private final ModelMapper mapper = new ModelMapper();

    public PersonajeService() {
        // personaRepository = new PersonaRepository();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    }

    public List<PersonajeDto> find(String query){
        List<Personaje> personajesHallados = personajeRepository.personajesHallados(query);
        return personajesHallados.stream().map(personaje -> mapper.map(personaje,PersonajeDto.class))
                .collect(Collectors.toList());

    }
}
