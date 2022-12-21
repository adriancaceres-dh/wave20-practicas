package com.bootcamp.repositorio;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    boolean guardarElemento(T elemento);

    boolean eliminarElemento(String id);

    Optional<T> obtenerElemento(String id);

    List<T> obtenerElementos();
}
