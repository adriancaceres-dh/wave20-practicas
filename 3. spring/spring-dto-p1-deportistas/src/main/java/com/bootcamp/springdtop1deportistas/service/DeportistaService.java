package com.bootcamp.springdtop1deportistas.service;

import com.bootcamp.springdtop1deportistas.dto.DeporteDTO;
import com.bootcamp.springdtop1deportistas.dto.request.DeportistaRequestDTO;
import com.bootcamp.springdtop1deportistas.dto.response.DeportistaResponseDTO;
import com.bootcamp.springdtop1deportistas.model.Deporte;
import com.bootcamp.springdtop1deportistas.model.Nivel;
import com.bootcamp.springdtop1deportistas.model.Persona;
import com.bootcamp.springdtop1deportistas.repository.DeporteRepository;
import com.bootcamp.springdtop1deportistas.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeportistaService {
    private final PersonaRepository personaRepository;
    private final DeporteRepository deporteRepository;

    public boolean add(DeportistaRequestDTO deportistaRequestDTO) {
        try {
            Deporte deporte = new Deporte(deportistaRequestDTO.getNombreDeporte(), Nivel.valueOf(deportistaRequestDTO.getNivelDeporte().toUpperCase()));
            Persona persona = new Persona(deportistaRequestDTO.getNombreApellido(), deportistaRequestDTO.getEdad(), deporte);
            if (!deporteRepository.contains(deporte))
                return false;
            return personaRepository.add(persona);
        }
        catch (IllegalArgumentException e) { return false; }
    }

    //Devuelve la lista de DeportistasResponseDTO cuyo nombre contiene el name pasado por parámetro
    public List<DeportistaResponseDTO> findByName(String name) {
        List<Persona> personas = personaRepository.filterByName(name);
        List<DeportistaResponseDTO> deportistasResponseDTO = new ArrayList<>();
        personas.forEach(p -> deportistasResponseDTO.add(new DeportistaResponseDTO(p.getNombreApellido(), p.getDeporte().getNombre())));
        return deportistasResponseDTO;
    }
}
