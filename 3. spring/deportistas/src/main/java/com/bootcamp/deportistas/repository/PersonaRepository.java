package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository {

private List<Persona> personaList;

public PersonaRepository() {
    personaList = new ArrayList<>();
    Persona persona1 = Persona.builder()
            .nombre("Cindy")
            .apellido("Ortega Palma")
            .edad(25)
            .nombreDeporte("Ballet")
            .build();

    personaList.add(persona1);
}
    @Override
    public boolean addPersona(Persona persona) {
        personaList.add(persona);
        return true;
    }

    @Override
    public List<Persona> getPersonas() {
        return this.personaList;
    }
}
