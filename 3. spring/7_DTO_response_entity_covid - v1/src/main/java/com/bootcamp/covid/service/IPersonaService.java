package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.response.GrupoRiesgoResponseDto;

import java.util.List;

public interface IPersonaService {

    public List<GrupoRiesgoResponseDto> grupoRiesgo();
}
