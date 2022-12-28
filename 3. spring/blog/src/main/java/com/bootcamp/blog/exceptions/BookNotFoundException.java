package com.bootcamp.blog.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException (String message) {
        super(message);
    }
}
