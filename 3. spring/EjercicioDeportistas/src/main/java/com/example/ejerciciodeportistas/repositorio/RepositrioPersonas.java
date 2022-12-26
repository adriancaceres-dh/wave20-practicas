package com.example.ejerciciodeportistas.repositorio;

import com.example.ejerciciodeportistas.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositrioPersonas {

  private static RepositrioPersonas instace = null;
  private List<Persona> personas;

  private RepositrioPersonas() {
    personas = new ArrayList<>();
  }

  public static RepositrioPersonas getInstance() {
    if (instace == null) {
      instace = new RepositrioPersonas();
    }
    return instace;
  }

  public void agregarPersona(Persona persona) {
    personas.add(persona);
  }

  public List<Persona> getPersonas() {
    return personas;
  }

  public Persona getPersona(String nombre) {
    for (Persona persona : personas) {
      if (persona.getNombre().equals(nombre)) {
        return persona;
      }
    }
    return null;
  }
}
