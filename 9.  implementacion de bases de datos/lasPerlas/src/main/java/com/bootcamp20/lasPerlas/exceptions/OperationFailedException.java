package com.bootcamp20.lasPerlas.exceptions;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException() {
    }

    public OperationFailedException(String message) {
        super(message);
    }
}
