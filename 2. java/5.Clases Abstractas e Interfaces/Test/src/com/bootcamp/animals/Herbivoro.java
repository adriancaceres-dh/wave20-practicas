package com.bootcamp.animals;

public interface Herbivoro {

    default boolean comeHierba() {
        return true;
    }
}
