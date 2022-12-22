package com.bootcamp.repository;

public interface Calculo<U> {
    public Double calcular();
    public U verificar(Long dni, String nombre, String apellido);
}
