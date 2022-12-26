package com.wave20.ejercicio_deportistas.service;

import com.wave20.ejercicio_deportistas.DTO.DeporteDTO;
import com.wave20.ejercicio_deportistas.model.Deporte;
import com.wave20.ejercicio_deportistas.model.Persona;
import com.wave20.ejercicio_deportistas.repository.DeporteRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeporteService {

    private static DeporteRepository deporteRepository = new DeporteRepository();


    public static List<DeporteDTO> listarDeportes() {
        if (!deporteRepository.getDeportes().isEmpty()) {
            return deporteRepository.getDeportes().stream().map(d -> new DeporteDTO(d.getNombre(), d.getNivel())).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static Optional<DeporteDTO> getDeportePorNombre(String nombre) {
        Optional<Deporte> d = deporteRepository.getDeporte(nombre);
        Optional<DeporteDTO> deporteDTO;
        if (d.isPresent()) {
            deporteDTO = Optional.of(new DeporteDTO(d.get().getNombre(), d.get().getNivel()));
        } else {
            deporteDTO = Optional.empty();
        }
        return deporteDTO;
    }


}
