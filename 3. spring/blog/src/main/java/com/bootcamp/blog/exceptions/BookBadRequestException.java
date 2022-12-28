package com.bootcamp.blog.exceptions;

public class BookBadRequestException extends RuntimeException{

    public BookBadRequestException (String message) {
        super(message);
    }
}
