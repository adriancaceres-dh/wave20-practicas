package com.bootcamp.showroom_elastic.util.mapper.implementation;

import com.bootcamp.showroom_elastic.dto.SaleDTO;
import com.bootcamp.showroom_elastic.model.Sale;
import com.bootcamp.showroom_elastic.util.mapper.ISaleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper implements ISaleMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Sale fromDTO(SaleDTO dto) {
        return modelMapper.map(dto, Sale.class);
    }

    @Override
    public SaleDTO toDTO(Sale entity) {
        return modelMapper.map(entity, SaleDTO.class);
    }
}
