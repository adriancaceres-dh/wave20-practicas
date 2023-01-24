package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.joyeria.dto.response.JoyaResponseDTO;

import java.util.List;

public interface IJoyaService {
    public JoyaResponseDTO save(JoyaRequestDTO dto);
    public JoyaResponseDTO findById(Long id);
    public List<JoyaResponseDTO> findAll();
    public String delete(Long id);
    public String update(Long id, JoyaRequestDTO dto);
}
