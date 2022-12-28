package com.Arquitectura.MulticapaP1VIVO.StarWars.Service;

import com.Arquitectura.MulticapaP1VIVO.StarWars.Dto.PersonajeDto;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Dto.PersonajeRetornoDto;
import com.Arquitectura.MulticapaP1VIVO.StarWars.Repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajesService {
    @Autowired
    PersonajeRepository personajeRepository;
    PersonajeRetornoDto personajeRetornoDto;
    public List<PersonajeDto> encontrarTodos()
    {
        return personajeRepository.getPersonajes().stream().collect(Collectors.toList());
    }

    public List<PersonajeRetornoDto> todos()
    {
        List<PersonajeRetornoDto> personajes = new ArrayList<>();
        personajes.add(personajeRepository.getPersonajes().stream().forEach(x -> personajeRetornoDto.setName(x.getName())));
        return personajes;
    }

    public PersonajeDto buscarPorNombre(String nombre)
    {
        return personajeRepository.getPersonajes().stream().filter(x-> x.getName().startsWith(nombre)).collect(Collectors.toList()).get(0);
    }

}
