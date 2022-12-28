package com.bootcamp.blog.exceptions;

public class BookAlreadyExistsException extends RuntimeException{

    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
