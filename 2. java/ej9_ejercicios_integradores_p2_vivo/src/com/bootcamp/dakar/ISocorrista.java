package com.bootcamp.dakar;

public interface ISocorrista <T extends Vehiculo>{

    public boolean socorrer(T vehiculo);
}
