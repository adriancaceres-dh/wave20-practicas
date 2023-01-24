package com.bootcamp.qa_testers.service;

import com.bootcamp.qa_testers.dto.response.MessageDTO;

import java.util.List;

public interface ICrudService<EntityDTO> {

    MessageDTO create(EntityDTO entityDTO);
    List<EntityDTO> getAll();
    EntityDTO getById(Long id);
    MessageDTO update(Long id, EntityDTO entityDTO);
    MessageDTO deleteById(Long id);
}
