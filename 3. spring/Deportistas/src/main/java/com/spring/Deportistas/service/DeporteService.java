package com.spring.Deportistas.service;

import com.spring.Deportistas.dto.responseDto.DeporteResponseDTO;
import com.spring.Deportistas.model.Deporte;
import com.spring.Deportistas.repository.DeporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DeporteService {

    public static ResponseEntity<List<DeporteResponseDTO>> devolverTodosLosDeportes(){
        List<DeporteResponseDTO> deportes = DeporteRepository.findSports().stream().map(e -> new DeporteResponseDTO(e.getNombre(),e.getNivel())).collect(Collectors.toList());
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    public static ResponseEntity<DeporteResponseDTO> encontrarDeporte(String deporteBuscado) {
        Deporte deporte = DeporteRepository.findSport(deporteBuscado);
        if(deporte != null){
            DeporteResponseDTO deporteResponse = new DeporteResponseDTO(deporte.getNombre(),deporte.getNivel());
            return new ResponseEntity<>(deporteResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
