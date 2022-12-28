package com.bootcamp.springdtop1deportistas.service;

import com.bootcamp.springdtop1deportistas.dto.DeporteDTO;
import com.bootcamp.springdtop1deportistas.model.Deporte;
import com.bootcamp.springdtop1deportistas.model.Nivel;
import com.bootcamp.springdtop1deportistas.repository.DeporteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DeporteService {
    private final DeporteRepository deporteRepository;

    public boolean add(DeporteDTO deporteDTO) {
        try {
            Deporte deporte = new Deporte(deporteDTO.getNombre(), Nivel.valueOf(deporteDTO.getNivel().toUpperCase()));
            return deporteRepository.add(deporte);
        }
        catch (IllegalArgumentException e) { return false; }
    }

    //Devuelve la lista de DeporteDTO cuyo nombre contiene el name pasado por parámetro
    public List<DeporteDTO> findByName(String name) {
        List<Deporte> deportes = deporteRepository.filterByName(name);
        List<DeporteDTO> deportesDTO = new ArrayList<>();
        deportes.forEach(d -> deportesDTO.add(new DeporteDTO(d.getNombre(), d.getNivel().name())));
        return deportesDTO;
    }
}
