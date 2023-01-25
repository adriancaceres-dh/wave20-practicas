package com.example.LaPerlaCrud.service;

import com.example.LaPerlaCrud.dto.JoyaDTO;
import com.example.LaPerlaCrud.dto.MessageDTO;

import java.util.List;

public interface IServiceJoya {

    JoyaDTO saveJoya(JoyaDTO personDTO);

    JoyaDTO getJoyaById(Integer id);

    List<JoyaDTO> getAllJoyas();

    MessageDTO deleteJoya(Integer id);

}
