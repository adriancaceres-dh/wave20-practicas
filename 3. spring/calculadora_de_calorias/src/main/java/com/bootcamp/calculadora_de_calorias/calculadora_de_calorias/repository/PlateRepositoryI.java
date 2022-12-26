package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.PlateDTO;

import java.util.List;

public interface PlateRepositoryI {
    List<PlateDTO> getPlates();
}
