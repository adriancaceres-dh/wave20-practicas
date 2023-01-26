package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.request.CompleteJoyaRequestDTO;
import com.bootcamp.LasPerlas.dto.request.JoyaRequestDto;
import com.bootcamp.LasPerlas.dto.response.JoyaResponseDto;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    public Joya findJoya(Long id);
    public List<JoyaResponseDto> getJoyas();
    public void disableJoya(Long id);
    public Long saveJoya(JoyaRequestDto joya);
    public JoyaResponseDto editJoya(Long id, JoyaRequestDto joya);
}
