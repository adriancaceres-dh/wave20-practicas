package com.example.seguros.service.interfaces.generic;

import com.example.seguros.dto.MensajeDto;

import java.util.List;

public interface ICrudService <T,ID>{
    T newEntity(T dto);
    List<String> getAllEntities();
    T getEntityById(ID id);
    T updateEntity(T dto, ID id);
    MensajeDto deleteEntity(ID id);

}
