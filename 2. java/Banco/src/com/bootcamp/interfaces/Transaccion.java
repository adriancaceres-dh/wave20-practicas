package com.bootcamp.interfaces;

public interface Transaccion {
    void transaccionOk(String nombreOperacion);
    void transaccionNoOk(String nombreOperacion);
}
