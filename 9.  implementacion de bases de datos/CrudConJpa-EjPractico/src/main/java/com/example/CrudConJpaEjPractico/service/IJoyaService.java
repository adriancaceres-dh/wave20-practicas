package com.example.CrudConJpaEjPractico.service;

import com.example.CrudConJpaEjPractico.DTO.JoyaDTO;

import java.util.List;

public interface IJoyaService {

    JoyaDTO create(JoyaDTO joyaDTO);
    List<JoyaDTO> getJoyas();

}
