package com.bootcamp.interfaces;

import java.util.List;

public interface ICRUD <T>{


    public int adicionarElemento(T elemento);
    public int eliminarElemento(T elemento);
    public T obtenerElementoByPos(int pos);
    //public T obtenerElementoBy(String campo);
    public boolean existeElemento (T elemento);

    //public boolean modificarElemento(T elemento);


}
