package com.bootcamp.qa_testers.qa_testers.service;

import com.bootcamp.qa_testers.qa_testers.dto.MessageDTO;

import java.util.List;

public interface CRUD <EntityDTO>{
    MessageDTO create(EntityDTO dto);
    MessageDTO update(EntityDTO dto);
    EntityDTO getById(Long id);
    List<EntityDTO> getAll();
    MessageDTO deleteById(Long id);
}
