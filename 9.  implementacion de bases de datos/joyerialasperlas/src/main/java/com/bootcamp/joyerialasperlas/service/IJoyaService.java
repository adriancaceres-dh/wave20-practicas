package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.dto.JoyaRequestDTO;
import com.bootcamp.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    Integer crearJoya(JoyaRequestDTO joya);

    List<Joya> getAllJoyas();

    String deleteJoya(Integer id);

    Joya updateJoya(JoyaRequestDTO joya, Integer id);
}
