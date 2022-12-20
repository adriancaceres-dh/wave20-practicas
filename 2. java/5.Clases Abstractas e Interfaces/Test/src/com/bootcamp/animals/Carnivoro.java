package com.bootcamp.animals;

public interface Carnivoro {

    default boolean comeCarne() {
        return true;
    }
}
