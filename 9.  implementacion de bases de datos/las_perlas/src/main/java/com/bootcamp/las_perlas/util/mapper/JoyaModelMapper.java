package com.bootcamp.las_perlas.util.mapper;

import com.bootcamp.las_perlas.dto.JoyaConIdDTO;
import com.bootcamp.las_perlas.dto.JoyaDTO;
import com.bootcamp.las_perlas.model.Joya;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class JoyaModelMapper implements IJoyaMapper{
    private final ModelMapper modelMapper;

    public JoyaModelMapper() {
        modelMapper = new ModelMapper();
    }

    @Override
    public Joya fromDTO(JoyaDTO joyaDTO) {
        return modelMapper.map(joyaDTO, Joya.class);
    }

    @Override
    public Joya fromDTO(JoyaConIdDTO joyaConIdDTO) {
        return modelMapper.map(joyaConIdDTO, Joya.class);
    }

    @Override
    public JoyaConIdDTO toDTO(Joya joyaDTO) {
        return modelMapper.map(joyaDTO, JoyaConIdDTO.class);
    }
}
