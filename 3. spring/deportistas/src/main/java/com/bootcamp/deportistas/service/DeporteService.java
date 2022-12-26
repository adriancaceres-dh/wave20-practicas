package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.response.DeporteResponseDto;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.repository.DeporteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeporteService {
    private DeporteRepository deporteRepository;
    public DeporteService() {
        deporteRepository = new DeporteRepository();
    }
    public List<DeporteResponseDto> findSports() {
        List<DeporteResponseDto> deportes = new ArrayList<>();
        deporteRepository.findSports().stream()
                .forEach(d -> deportes.add(new DeporteResponseDto(d.getNombre(),d.getNivel())));
        return deportes;
    }
    public DeporteResponseDto findSport(String sport) {
        Optional<Deporte> deporte = deporteRepository.findSports().stream()
                .filter(e -> e.getNombre().equals(sport)).findAny();
        if(deporte.isPresent()) {
            DeporteResponseDto deporteResponseDto = new DeporteResponseDto();
            deporteResponseDto.setNombre(deporte.get().getNombre());
            deporteResponseDto.setNivel(deporte.get().getNivel());
            return deporteResponseDto;
        } else {
            return null;
        }

    }
}
