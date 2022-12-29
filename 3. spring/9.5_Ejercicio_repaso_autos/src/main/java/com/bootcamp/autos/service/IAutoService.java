package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.request.AutoRequestDto;
import com.bootcamp.autos.dto.response.AutoResponseDto;

import java.util.List;

public interface IAutoService {

    public List<AutoResponseDto> getAutos() ;

    public String agregarAuto(AutoRequestDto autoRequestDto);

}
