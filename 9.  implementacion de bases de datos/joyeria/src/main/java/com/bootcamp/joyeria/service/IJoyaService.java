package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.JoyaDto;
import com.bootcamp.joyeria.entity.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaDto> getJoyas();
    Long saveJoya(JoyaDto joyaDto);
    boolean deleteJoya(Long id);
    Joya findJoya(Long id);
}
