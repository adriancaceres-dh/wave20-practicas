package com.bootcamp.blog.exception;

public class IdAlreadyExistsException extends RuntimeException{

    public IdAlreadyExistsException(String message){
        super(message);
    }
}
