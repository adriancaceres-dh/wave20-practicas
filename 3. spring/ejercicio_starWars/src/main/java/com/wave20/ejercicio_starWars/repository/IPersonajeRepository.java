package com.wave20.ejercicio_starWars.repository;



import com.wave20.ejercicio_starWars.model.Personaje;
import java.util.List;


public interface IPersonajeRepository {
    List<Personaje> obtenerPersonajes(String nombre);
}
