package com.bootcamp.Starwars.service;

import com.bootcamp.Starwars.dto.PersonajeDTO;
import com.bootcamp.Starwars.model.Personaje;
import com.bootcamp.Starwars.repository.IPersonajesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements IPersonajeService{
    @Autowired
    IPersonajesRepository iPersonajesRepository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public List<PersonajeDTO> buscarTodosPorNombre(String nombre) {
       List<Personaje> personajes =  iPersonajesRepository.buscarTodosPorNombre();

        List<PersonajeDTO> personajesFiltrados = new ArrayList<>();

        personajesFiltrados = personajes.stream().filter(x->x.getName().contains(nombre)).collect(Collectors.toList()).stream().map(p-> mapper.map(p,PersonajeDTO.class)).collect(Collectors.toList());


        return personajesFiltrados;
    }
}
