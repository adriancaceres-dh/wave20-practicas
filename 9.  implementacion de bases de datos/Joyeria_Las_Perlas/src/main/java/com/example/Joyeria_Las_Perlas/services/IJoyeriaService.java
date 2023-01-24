package com.example.Joyeria_Las_Perlas.services;

import com.example.Joyeria_Las_Perlas.DTO.AllJoyasResponseDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaCreatedDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaDto;

public interface IJoyeriaService{
    AllJoyasResponseDto getJoyas();
    JoyaCreatedDto saveJoya(JoyaDto newJoya);
    Boolean deleteJoya(Integer id);
    JoyaDto findJoya(Integer id);
}
