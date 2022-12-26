package com.example.starwars.service;

import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.repository.IPersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    @Autowired
    IPersonajeRepository personajeRepository;
    public List<PersonajeDTO> personajeDTOList(){
        ModelMapper modelMapper = new ModelMapper();
        List<PersonajeDTO> listaPersonajesDto = personajeRepository.listaPersonajes()
                .stream().map(p -> modelMapper.map(p, PersonajeDTO.class)).collect(Collectors.toList());
        return listaPersonajesDto;
    }
    public List<PersonajeDTO> personajesFiltradosDTO(String nombre){
        ModelMapper modelMapper = new ModelMapper();
        List<PersonajeDTO> listaPersonajesDto = personajeRepository.personajeXNombre(nombre)
                .stream().map(p -> modelMapper.map(p, PersonajeDTO.class)).collect(Collectors.toList());
        return listaPersonajesDto;
    }
}
