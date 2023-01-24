package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.dto.response.JoyaDTOResponse;

import java.util.List;

public interface IJoyaService {

    JoyaDTOResponse addJewel(JoyaDTORequest joyaDTO);
    List<JoyaDTOResponse> getJewels();
    JoyaDTOResponse updateJewel(JoyaDTORequest joyaDTO, Long id_modificar);
    String deleteJewel(Long id);
}
