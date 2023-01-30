package com.implementacion_bd.Joyeria.Service;

import com.implementacion_bd.Joyeria.Entities.Joya;

import java.util.List;

public interface ICRUDService<T, U, V, W> {
    //T = request
    //U = id
    //V = response with only id
    //W = responseDTO

    List<W> findAll();

    W findById(U id);

    V create(T requestDto);

    W update(U id, T requestDto);

    void delete(U id);

}
