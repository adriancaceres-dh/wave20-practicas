package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.GemDto;
import com.bootcamp.joyeria.dto.MessageDto;

import java.util.List;

public interface IGemService {
    MessageDto createGem(GemDto gemDto);
    List<GemDto> getAllGem();
    MessageDto deleteGem(Long id);
    GemDto UpDate(Long id,GemDto gemDto);


}
