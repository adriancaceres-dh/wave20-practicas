package com.bootcamp.las_perlas.service;

import com.bootcamp.las_perlas.dto.JoyaConIdDTO;
import com.bootcamp.las_perlas.dto.JoyaDTO;

import java.util.List;

public interface IJoyaService {
    JoyaConIdDTO crear(JoyaDTO joyaDTO);
    List<JoyaConIdDTO> listarEnVenta();
    JoyaConIdDTO darDeBaja(Long id);
    JoyaConIdDTO actualizar(Long id, JoyaDTO joyaConIdDTO);
}
