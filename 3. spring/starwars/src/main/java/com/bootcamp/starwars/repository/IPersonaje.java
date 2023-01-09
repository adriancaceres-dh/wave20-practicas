package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface IPersonaje {
    List<Personaje> buscarPorNombre(String nombre);

}
