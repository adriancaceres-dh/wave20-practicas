package com.bootcamp;

public interface Transaccion {
    default void transaccionOk(){
        System.out.println("Transacción exitosa");
    };
    default void transaccionNoOk(){
        System.out.println("Error en la transacción");
    };
}
