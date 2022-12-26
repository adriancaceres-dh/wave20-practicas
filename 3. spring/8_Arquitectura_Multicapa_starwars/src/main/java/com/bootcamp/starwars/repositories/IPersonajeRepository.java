package com.bootcamp.starwars.repositories;

import com.bootcamp.starwars.model.Personaje;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonajeRepository {

    List<Personaje> findAllByNameContains(String query);
}
