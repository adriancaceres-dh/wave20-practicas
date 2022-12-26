package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.response.SintomaResponseDto;

import java.util.List;

public interface ISintomaService {

    public List<SintomaResponseDto> findSympton();

    public SintomaResponseDto findSympton(String nombre);

}
