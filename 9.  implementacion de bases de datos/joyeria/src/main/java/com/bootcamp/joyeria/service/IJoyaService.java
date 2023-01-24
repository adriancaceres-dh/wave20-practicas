package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.ActualizaJoyaDto;
import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MensajeDto;
import com.bootcamp.joyeria.entity.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaResponseDto> obtenerJoyas();
    Long guardarJoya(Joya joya);
    MensajeDto eliminarJoya(Long id);
    Joya buscarJoya(Long id);
    MensajeDto crearJoya(JoyaRequestDto joyaDto);
    ActualizaJoyaDto actualizarJoya(Long id, JoyaRequestDto joyaDto);
}
