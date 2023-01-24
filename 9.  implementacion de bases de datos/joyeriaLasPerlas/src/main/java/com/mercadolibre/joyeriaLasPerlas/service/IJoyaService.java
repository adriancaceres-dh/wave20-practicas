package com.mercadolibre.joyeriaLasPerlas.service;

import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaRequestDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.JoyaResponseDTO;
import com.mercadolibre.joyeriaLasPerlas.DTO.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IJoyaService {

    public MessageDTO crearJoya(JoyaRequestDTO joyaRequestDTO);

    public JoyaResponseDTO obtenerJoya(int id) throws Exception;

    public List<JoyaResponseDTO> obtenerTodasLasJoyas() throws Exception;

    public MessageDTO eliminarJoya(int id);
}
