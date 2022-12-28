package com.ejercicio.StarWars.service;

import com.ejercicio.StarWars.modelo.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {
    public List<Personaje> findAll(String name);
}
