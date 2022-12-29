package com.spring.Deportistas.repository;

import com.spring.Deportistas.dto.responseDto.DeporteResponseDTO;
import com.spring.Deportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {
    public static List<Deporte> deportes = new ArrayList<>();

    public static List<Deporte> findSports() {
        return DeporteRepository.deportes;
    }

    public static Deporte findSport(String desporte){
        return findSports().stream().filter(e -> e.getNombre().equals(desporte)).findAny().orElse(null);
    }
}
