package com.bootcamp.calculadora_calorias.service;

import com.bootcamp.calculadora_calorias.dto.PlatoDTO;

import java.util.Optional;

public interface IPlatoService {
    Optional<PlatoDTO> obtenerInformacionPlato(String nombre);
}
