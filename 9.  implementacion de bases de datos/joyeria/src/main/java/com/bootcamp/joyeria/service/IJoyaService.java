package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.entity.Joya;

import java.util.List;

public interface IJoyaService {

    List<JoyaResponseDto> getJoyas();
    void saveJoya(Joya joya);
    boolean deleteJoya(Long id);
    Joya findJoya(Long id);
}
