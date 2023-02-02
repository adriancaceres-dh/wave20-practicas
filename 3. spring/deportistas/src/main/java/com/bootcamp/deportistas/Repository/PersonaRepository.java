package com.bootcamp.deportistas.Repository;

import com.bootcamp.deportistas.Model.Deporte;
import com.bootcamp.deportistas.Model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository {
    private List<Persona> personas;
    private PersonaRepository(){
        personas = new ArrayList<>();
        personas.add(new Persona("Lalo","Landa",15,new Deporte("Tenis", "Avanzado")));
        personas.add(new Persona("Pepe","Prado",20,new Deporte("Tenis", "Avanzado")));
        personas.add(new Persona("Juan","Peña",25,new Deporte("Tenis", "Avanzado")));
        personas.add(new Persona("Ana","Gomez",18,new Deporte("Tenis", "Avanzado")));
    }
    public List<Persona> getPersonas(){
        return personas;
    }
    public List<Persona> esDeportista(){
        return personas.stream()
                .filter(p-> p.getDeporte() != null)
                .collect(Collectors.toList());
    }
}
