package com.socialmeli.be_java_hisp_w20_g8.exceptions;

public class OperationFailedException extends RuntimeException{

    public OperationFailedException() {}
    public OperationFailedException(String message) {
        super(message);
    }
}
