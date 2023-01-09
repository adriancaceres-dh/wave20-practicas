package com.bootcamp.starwars.service;

import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.repository.IPersonajeImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final IPersonajeImpl personajeImpl;

    public PersonajeService(IPersonajeImpl personajeImpl) {
        this.personajeImpl = personajeImpl;
    }

    public List<Personaje> buscarPorNombre(String nombre) {
        return personajeImpl.buscarPorNombre(nombre);
    }
}
