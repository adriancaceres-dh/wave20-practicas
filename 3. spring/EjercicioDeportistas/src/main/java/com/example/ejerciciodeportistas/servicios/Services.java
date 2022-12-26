package com.example.ejerciciodeportistas.servicios;

import com.example.ejerciciodeportistas.dtos.PersonaDeporteDTO;
import com.example.ejerciciodeportistas.model.Deporte;
import com.example.ejerciciodeportistas.dtos.DeporteDTO;
import com.example.ejerciciodeportistas.model.Persona;
import com.example.ejerciciodeportistas.repositorio.RepositorioDeportes;
import com.example.ejerciciodeportistas.repositorio.RepositrioPersonas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

  public List<DeporteDTO> obtenerDeportes() {
    List<DeporteDTO> deportesDTO = new ArrayList<>();
    for (Deporte deporte : RepositorioDeportes.getInstance().getDeportes()) {
      deportesDTO.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
    }
    return deportesDTO;
  }

  public DeporteDTO buscarDeporte(String name) {
    RepositorioDeportes repositorio = RepositorioDeportes.getInstance();
    Deporte deporte = repositorio.getDeporte(name);
    DeporteDTO deporteDTO = new DeporteDTO();
    deporteDTO.setNombre(deporte.getNombre());
    deporteDTO.setNivel(deporte.getNivel());
    return deporteDTO;
  }

  public List<PersonaDeporteDTO> obtenerPersonasDeportes() {
    List<PersonaDeporteDTO> lista = new ArrayList<>();
    RepositrioPersonas repositorioPersonas = RepositrioPersonas.getInstance();
    for (Persona persona : repositorioPersonas.getPersonas()) {
      String deporte = persona.getDeporte().getNombre();
      PersonaDeporteDTO personaDeporteDTO = new PersonaDeporteDTO(persona.getNombre(), persona.getApellido(), deporte);
      lista.add(personaDeporteDTO);
    }
    return lista;
  }
}
