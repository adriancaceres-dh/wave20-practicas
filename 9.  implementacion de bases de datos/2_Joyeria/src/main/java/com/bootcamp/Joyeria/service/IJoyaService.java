package com.bootcamp.Joyeria.service;

import com.bootcamp.Joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.Joyeria.dto.response.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {

    public Long createJoya(JoyaRequestDTO joyaRequestDTO);
    public List<JoyaResponseDTO> findAll();
    public Boolean deleteById (Long id);
    public JoyaResponseDTO updateJoya(Long id, JoyaRequestDTO joyaRequestDTO);
}
