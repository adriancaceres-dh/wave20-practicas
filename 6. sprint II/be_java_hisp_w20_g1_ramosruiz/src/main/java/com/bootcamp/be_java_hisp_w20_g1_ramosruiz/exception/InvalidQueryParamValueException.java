package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.exception;

public class InvalidQueryParamValueException extends RuntimeException {

    public InvalidQueryParamValueException() { }

    public InvalidQueryParamValueException(String message) {
        super(message);
    }
}
