package com.example.LaPerlaCrud.service;

import com.example.LaPerlaCrud.dto.JoyaDTO;
import com.example.LaPerlaCrud.dto.MessageDTO;

import java.util.List;

public interface IServiceJoya {

    MessageDTO saveJoya(JoyaDTO joyaDTO);

    JoyaDTO updateJoya(Integer id_modificar,JoyaDTO joyaDTO);

    List<JoyaDTO> getAllJoyas();

    MessageDTO deleteJoya(Integer id);

}
