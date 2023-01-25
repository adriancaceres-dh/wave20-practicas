package com.withHibernate.Burami.service;


import com.withHibernate.Burami.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ICrudService<EntityDTO>{

    MessageDTO createEntity(EntityDTO dto);

    MessageDTO updateEntity(EntityDTO dto);

    EntityDTO getEntityById(Long id);

    List<EntityDTO> getAllEntities();

    MessageDTO deleteEntity(Long id);

}
