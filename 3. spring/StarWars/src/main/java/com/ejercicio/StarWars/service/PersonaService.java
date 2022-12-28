package com.ejercicio.StarWars.service;

import com.ejercicio.StarWars.modelo.Personaje;
import com.ejercicio.StarWars.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonaService implements IPersonaService{

    private PersonaRepository personaRepository;

    public PersonaService(){
        this.personaRepository = new PersonaRepository();
    }

    public List<Personaje> findAll(String name){
        System.out.println("Maria");
        return personaRepository.getListaPersonajes().stream().filter(x->x.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }
}
