package com.bootcamp.cars.exeptions;

public class IdAlreadyExistException extends RuntimeException {

    //Constructor
    public IdAlreadyExistException(String message) {
        super(message);
    }
}
