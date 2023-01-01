package com.bootcamp.Deportistas.service;

import com.bootcamp.Deportistas.dto.DeportistaDTO;
import com.bootcamp.Deportistas.dto.PersonaDTO;
import com.bootcamp.Deportistas.model.Deporte;
import com.bootcamp.Deportistas.repository.DeporteRepository;
import com.bootcamp.Deportistas.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeportistaService {

    @Autowired
    DeporteRepository deporteRepository;
    @Autowired
    PersonaRepository personaRepository;

    public List<Deporte> getAll() {
        return deporteRepository.getDeportes();
    }

    public String getNivel(String name) {
        Optional<Deporte> deporteEncontrado = deporteRepository.getDeportes().stream().filter(deporte -> deporte.getNombre().equals(name)).findAny();
        if (deporteEncontrado.isPresent()){
            return deporteEncontrado.get().getNivel();
        }else
            return "Deporte no encontrado";
    }
    public List<DeportistaDTO> getDeportistas(){
        List<DeportistaDTO> deportista = personaRepository.getDeportistas().stream().map(
                persona -> new DeportistaDTO(persona.getNombre(),persona.getApellido(), persona.getDeportes().stream().map(deporte -> deporte.getNombre()).collect(Collectors.toList()))).collect(Collectors.toList());
        return deportista;
    }

    public List<PersonaDTO> getPeople() {
        ModelMapper mapper = new ModelMapper();
        List<PersonaDTO> personas = personaRepository.getPersonas().stream().map(persona -> mapper.map(persona, PersonaDTO.class)).collect(Collectors.toList());
        return personas;
    }
}


