package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MessageDto;
import com.bootcamp.joyeria.entity.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaResponseDto> obtenerJoyas();
    Long guardarJoya(Joya joya);
    MessageDto eliminarJoya(Long id);
    Joya buscarJoya(Long id);
    MessageDto crearJoya(JoyaRequestDto joyaDto);
}
