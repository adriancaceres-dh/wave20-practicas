package com.starwars.StarWars.repositories;

import com.starwars.StarWars.dto.PersonajeDTO;
import java.util.List;

public interface StarWarsRepository {

    List<PersonajeDTO> loadDataBase();

}
