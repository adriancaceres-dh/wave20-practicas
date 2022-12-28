package com.wave20.ejercicio_calorias.service;



import com.wave20.ejercicio_calorias.dto.PlatoDTO;

import java.util.List;
import java.util.Optional;

public interface IPlatoService {
    Optional<PlatoDTO> obtenerInformacionPlato(String nombre);

    List<Optional<PlatoDTO>> obtenerInformacionPlatos(List<String> nombres);
}