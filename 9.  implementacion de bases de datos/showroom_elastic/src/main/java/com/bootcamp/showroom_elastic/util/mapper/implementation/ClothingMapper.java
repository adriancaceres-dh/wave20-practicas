package com.bootcamp.showroom_elastic.util.mapper.implementation;

import com.bootcamp.showroom_elastic.dto.ClothingDTO;
import com.bootcamp.showroom_elastic.model.Clothing;
import com.bootcamp.showroom_elastic.util.mapper.IClothingMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClothingMapper implements IClothingMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Clothing fromDTO(ClothingDTO dto) {
        return modelMapper.map(dto, Clothing.class);
    }

    @Override
    public ClothingDTO toDTO(Clothing entity) {
        return modelMapper.map(entity, ClothingDTO.class);
    }
}
