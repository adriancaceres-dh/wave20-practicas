package com.bootcamp.siniestrovehiculo.service.interfaces.generics;

import com.bootcamp.siniestrovehiculo.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T personDTO);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
