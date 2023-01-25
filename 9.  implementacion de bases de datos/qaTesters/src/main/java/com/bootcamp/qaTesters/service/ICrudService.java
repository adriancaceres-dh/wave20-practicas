package com.bootcamp.qaTesters.service;

import com.bootcamp.qaTesters.dto.MessageDto;

import java.util.List;

public interface ICrudService<EntityDTO> {
    MessageDto createEntity(EntityDTO dto);
    MessageDto updateEntity(EntityDTO dto);
    EntityDTO getEntityById(Long id);
    List<EntityDTO> getAllEntities();
    MessageDto deleteEntity(Long id);

}
