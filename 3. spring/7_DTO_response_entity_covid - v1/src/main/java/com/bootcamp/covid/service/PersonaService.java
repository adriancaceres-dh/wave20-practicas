package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.response.GrupoRiesgoResponseDto;
import com.bootcamp.covid.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public PersonaService() {
        // personaRepository = new PersonaRepository();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    }

    public List<GrupoRiesgoResponseDto> grupoRiesgo() {
        /*
        return personaRepository.gerPersonas().stream()
                .filter(p -> p.getSintomas().size()>0 && p.edad() > 60 )
                .collect(Collectors.toList())
                .stream().map(p-> new GrupoRiesgoResponseDto(p.getNombre(),p.getApellido()))
                .collect(Collectors.toList());
         */
        return personaRepository.gerPersonas().stream()
                .filter(p -> p.getSintomas().size()>0 && p.edad() > 60 )
                .collect(Collectors.toList())
                .stream().map(p-> mapper.map(p,GrupoRiesgoResponseDto.class))
                .collect(Collectors.toList());


    }

}
