package com.example.JPA_2601.service;

import com.example.JPA_2601.dto.MessageDTO;
import com.example.JPA_2601.dto.SaleDTO;

import java.util.List;

public interface ICrudService<T, ID> {

    T saveEntity(T ClothDTO);


    T getEntityById(ID id);

    List<T> getAllEntities();

    MessageDTO deleteEntity(ID id);
}
