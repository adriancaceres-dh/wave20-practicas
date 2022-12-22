package com.bootcamp.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <U>{
    public void guardar(U objeto);
    public void eliminar(Long id);
    public void mostrar();
    public Optional<U> buscar(Long id);
    public List<U> buscarTodos();

}
