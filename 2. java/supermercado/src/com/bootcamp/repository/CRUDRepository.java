package com.bootcamp.repository;
import java.util.List;
import  java.util.Optional;
public interface CRUDRepository <T>{
    public  void save(T objeto);
    public  void mostrarPantalla();
    public Optional<T> buscar(Integer id);
    public void eliminar (Integer id);
    public List<T> traerTodos();

}
