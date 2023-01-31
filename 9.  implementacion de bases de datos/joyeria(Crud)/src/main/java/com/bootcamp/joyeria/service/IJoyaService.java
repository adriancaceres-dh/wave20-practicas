package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.request.JoyaDTORequest;
import com.bootcamp.joyeria.dto.response.JoyaDTOResponse;
import com.bootcamp.joyeria.dto.response.MessageDTO;

import java.util.List;

public interface IJoyaService {
    MessageDTO save(JoyaDTORequest joyaDTO);

    List<JoyaDTOResponse> getAll();

    MessageDTO delete(Integer id);

    JoyaDTOResponse update(JoyaDTORequest joyaDTORequest, Integer id);

}
