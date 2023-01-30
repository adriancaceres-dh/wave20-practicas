package com.jpa3.clothes.Service;

import java.util.List;

public interface ICrudService<T, U, V> {
    T getById(Integer id);

    List<T> getAll();

    T add(U dto);

    V delete(Integer id);

    T update(U dto);
}
