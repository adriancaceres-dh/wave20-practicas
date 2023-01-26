package com.bootcamp.showroom_elastic.util.mapper.implementation;

import com.bootcamp.showroom_elastic.dto.SellDTO;
import com.bootcamp.showroom_elastic.model.Sell;
import com.bootcamp.showroom_elastic.util.mapper.ISellMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SellMapper implements ISellMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Sell fromDTO(SellDTO dto) {
        return modelMapper.map(dto, Sell.class);
    }

    @Override
    public SellDTO toDTO(Sell entity) {
        return modelMapper.map(entity, SellDTO.class);
    }
}
