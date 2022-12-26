package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.response.PersonaDeporteResponseDto;
import com.example.ejercicio_deportistas.model.Deporte;
import com.example.ejercicio_deportistas.model.Persona;
import com.example.ejercicio_deportistas.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaService {

    ModelMapper modelMapper;

    PersonaRepository personaRepository;

    public PersonaService() {
        modelMapper = new ModelMapper();
        personaRepository = new PersonaRepository();
    }

    public ResponseEntity<List<PersonaDeporteResponseDto>> findAll(){
        List<Persona> personas = personaRepository.findAll();
        List<PersonaDeporteResponseDto> personaDeporteResponseDtos = personas.stream().map(e ->{
           PersonaDeporteResponseDto personaDeporteResponseDto = new PersonaDeporteResponseDto(e.getNombre(),e.getApellido());
           for (Deporte d : e.getDeportes() ){
               personaDeporteResponseDto.getDeportes().add(d.getNombre());
           }
           return personaDeporteResponseDto;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(personaDeporteResponseDtos, HttpStatus.OK);

    }
}
