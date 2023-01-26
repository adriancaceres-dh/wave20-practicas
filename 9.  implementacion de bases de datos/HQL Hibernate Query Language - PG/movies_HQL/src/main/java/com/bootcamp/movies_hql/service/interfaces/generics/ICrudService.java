package com.bootcamp.movies_hql.service.interfaces.generics;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T crudDTO);
    T getEntityById(ID id);
    List<T> getAllEntities();
    String deleteEntity(ID id);
}
