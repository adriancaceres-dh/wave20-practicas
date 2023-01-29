package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;

import java.util.List;

public interface ICRUDService<EntityDTO> {
    MessageDTO createEntity(EntityDTO dto);
    EntityDTO getEntityById(Long id);
    List<EntityDTO> getAllEntities();
    MessageDTO updateEntity(Long id, EntityDTO dto);
    MessageDTO deleteEntity(Long id);


}
