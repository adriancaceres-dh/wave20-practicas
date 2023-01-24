package com.example.crud_joyeria.service;

import com.example.crud_joyeria.dto.JoyaDto;
import com.example.crud_joyeria.dto.MessageDto;
import com.example.crud_joyeria.dto.request.JoyaCreateDto;
import com.example.crud_joyeria.entity.Joya;

import java.util.List;

public interface IJoyaService {

    MessageDto create(JoyaCreateDto joyaCreateDto);

    List<JoyaDto> findAll();

    MessageDto logicDelete(Long id);

    JoyaDto modify(JoyaDto joyaDto,Long id);
}
