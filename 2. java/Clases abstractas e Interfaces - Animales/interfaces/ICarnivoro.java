package com.bootcamp.interfaces;

public interface ICarnivoro {

    default boolean comerCarne() {
        return true;
    }
}
