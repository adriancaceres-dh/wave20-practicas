package com.example.lasperlas.service;

import com.example.lasperlas.dto.ActionResponseDTO;
import com.example.lasperlas.dto.JoyaRequestDTO;
import com.example.lasperlas.dto.JoyaResponseDTO;

import java.util.List;

public interface IJoyeriaService {
  ActionResponseDTO newJewelry(JoyaRequestDTO dto);
  List<JoyaResponseDTO> getAllJewelry();
  ActionResponseDTO deleteJewelry(Integer id);
  ActionResponseDTO updateJewelry(Integer id, JoyaRequestDTO dto);
}
