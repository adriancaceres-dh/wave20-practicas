package com.bootcamp;

public interface SocorrerInterface<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
