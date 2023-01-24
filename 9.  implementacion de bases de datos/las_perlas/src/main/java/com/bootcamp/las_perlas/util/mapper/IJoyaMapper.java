package com.bootcamp.las_perlas.util.mapper;

import com.bootcamp.las_perlas.dto.JoyaConIdDTO;
import com.bootcamp.las_perlas.dto.JoyaDTO;
import com.bootcamp.las_perlas.model.Joya;

public interface IJoyaMapper {
    Joya fromDTO(JoyaDTO joyaDTO);
    Joya fromDTO(JoyaConIdDTO joyaConIdDTO);
    JoyaConIdDTO toDTO(Joya joyaDTO);
}
