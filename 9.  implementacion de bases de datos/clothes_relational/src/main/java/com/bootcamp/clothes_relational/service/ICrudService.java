package com.bootcamp.clothes_relational.service;

import com.bootcamp.clothes_relational.dto.response.MessageDTO;

import java.util.List;

public interface ICrudService<EntityDTO> {

    MessageDTO create(EntityDTO entityDTO);
    List<EntityDTO> getAll();
    EntityDTO getById(Long id);
    MessageDTO update(Long id, EntityDTO entityDTO);
    MessageDTO deleteById(Long id);
}