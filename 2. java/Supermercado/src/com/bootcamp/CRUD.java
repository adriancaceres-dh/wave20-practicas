package com.bootcamp;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{
    void guardar (T objeto);
    void mostrarPantalla();
    Optional<T> buscar (String id);
    void eliminar (String id);
    public List<T> traerTodos();
}
