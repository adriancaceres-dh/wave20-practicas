package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.common.JoyaDTO;
import com.bootcamp.joyeria.dto.request.CreateJoyaDTO;
import com.bootcamp.joyeria.dto.response.MessageDTO;
import com.bootcamp.joyeria.dto.response.UpdatedJoyaDTO;

import java.util.List;

public interface IJoyaService {

    MessageDTO createJoya(CreateJoyaDTO joyaDTO);
    List<JoyaDTO> getJoyas();
    JoyaDTO getJoyaById(Long id);
    UpdatedJoyaDTO updateJoya(Long id, CreateJoyaDTO joyaDTO);
    MessageDTO deleteJoyaById(Long id);
}
