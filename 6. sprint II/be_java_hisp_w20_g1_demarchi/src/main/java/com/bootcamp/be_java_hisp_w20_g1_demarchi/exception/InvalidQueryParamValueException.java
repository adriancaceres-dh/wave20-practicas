package com.bootcamp.be_java_hisp_w20_g1_demarchi.exception;

public class InvalidQueryParamValueException extends RuntimeException {

    public InvalidQueryParamValueException() { }

    public InvalidQueryParamValueException(String message) {
        super(message);
    }
}
