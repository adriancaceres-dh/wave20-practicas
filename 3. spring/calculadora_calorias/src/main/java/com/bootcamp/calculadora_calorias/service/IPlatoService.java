package com.bootcamp.calculadora_calorias.service;

import com.bootcamp.calculadora_calorias.dto.PlatoDTO;

public interface IPlatoService {
    PlatoDTO obtenerInformacionPlato(String nombre);
}
