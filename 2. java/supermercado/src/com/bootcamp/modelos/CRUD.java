package com.bootcamp.modelos;

import java.util.List;

public interface CRUD <T>{

    boolean crear(T elementoNuevo);
    T buscar(List<T> listaOriginal, String elementoABuscar);
    boolean remover( String elementoARemover);
    boolean modificar( T elementoAModificar);
}
