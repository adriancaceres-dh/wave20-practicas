package com.bootcamp.MiniSeries.service.interfaces.generics;



import com.bootcamp.MiniSeries.dto.MessageDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T t);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
