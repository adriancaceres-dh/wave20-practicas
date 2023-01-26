package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.MessageDTO;
import org.apache.logging.log4j.message.Message;

import java.util.List;

public interface ICRUDService<EntityDTO> {
    MessageDTO createEntity(EntityDTO dto);
    MessageDTO updateEntity(EntityDTO dto);
    List<EntityDTO> getAllEntities();
    MessageDTO deleteEntity(Long id);
}
