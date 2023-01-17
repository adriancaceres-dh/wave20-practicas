package com.bootcamp.be_java_hisp_w20_g7.exception;

public class OrderNotValidException extends RuntimeException {

    public OrderNotValidException(String message) {
        super(message);
    }
}
