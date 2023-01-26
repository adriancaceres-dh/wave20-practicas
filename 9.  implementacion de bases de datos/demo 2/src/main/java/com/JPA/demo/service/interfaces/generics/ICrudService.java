package com.JPA.demo.service.interfaces.generics;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T personDTO);

    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
