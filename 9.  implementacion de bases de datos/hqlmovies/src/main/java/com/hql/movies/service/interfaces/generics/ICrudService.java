package com.hql.movies.service.interfaces.generics;

import com.hql.movies.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T personDTO);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
