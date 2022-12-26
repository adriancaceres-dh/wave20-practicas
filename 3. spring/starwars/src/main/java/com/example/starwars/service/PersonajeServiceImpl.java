package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.repository.PersonajeRepository;
import com.example.starwars.repository.PersonajeRepositoryImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PersonajeDto> getAll() {
        return personajeRepository.getPersonajes()
                .stream()
                .map(p -> modelMapper.map(p, PersonajeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDto> getByName(String name) {
        return personajeRepository.getPersonajesByName(name)
                .stream()
                .map(p -> modelMapper.map(p, PersonajeDto.class))
                .collect(Collectors.toList());
    }
}
