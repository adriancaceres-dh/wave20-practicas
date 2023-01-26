package com.example.ejercicioopcional.service;

import com.example.ejercicioopcional.dto.MessageDTO;
import com.example.ejercicioopcional.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ICrudService<SaleDTO, Integer>{

    @Override
    public SaleDTO saveEntity(SaleDTO entityDTO) {
        return null;
    }

    @Override
    public SaleDTO getEntityById(Integer integer) {
        return null;
    }

    @Override
    public List<SaleDTO> getAllEntities() {
        return null;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        return null;
    }
}
