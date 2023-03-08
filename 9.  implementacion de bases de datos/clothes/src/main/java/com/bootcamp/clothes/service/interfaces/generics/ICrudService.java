package com.bootcamp.clothes.service.interfaces.generics;

import com.bootcamp.clothes.dto.response.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {
    MessageDTO saveEntity(T clotheDTO);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO updateEntity(ID id, T clotheDTO);

    MessageDTO deleteEntity(ID id);
}
