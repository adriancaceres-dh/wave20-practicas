package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;

import java.util.List;

public interface ICrudService<EntityDTO>{

    MessageDTO createEntity(EntityDTO dto);

    MessageDTO updateEntity(EntityDTO dto);

    EntityDTO getEntityById(Long id);

    List<EntityDTO> getAllEntities();

    MessageDTO deleteEntity(Long id);

}
