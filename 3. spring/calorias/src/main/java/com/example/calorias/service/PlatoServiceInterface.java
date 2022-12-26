package com.example.calorias.service;

import com.example.calorias.dto.PlatoDto;
import com.example.calorias.dto.PlatoNombrePesoDto;

import java.util.List;

public interface PlatoServiceInterface {
    PlatoDto getPlatoByNameAndWeight(String nombre, int weight);
    List<PlatoDto> getPlatosByNamesAndWeights(List<PlatoNombrePesoDto> platos);
}
