package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.exception.NotFoundException;

import java.util.List;

public interface IGenericCrudService<T, ID> {

    T saveEntity(T dto);

    T getEntityById(ID id) throws NotFoundException;

    List<T> getAllEntities();

    MessageDto deleteEntity(ID id);


}
