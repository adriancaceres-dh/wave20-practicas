package com.implementacion_bd.Joyeria.Service;

import com.implementacion_bd.Joyeria.Entities.Joya;

import java.util.List;

public interface ICRUDService<T> {

    List<T> findAll();

    T findById(Integer id);

    T create(T requestDto);

    T update(T requestDto);

    void delete(Integer id);

}
