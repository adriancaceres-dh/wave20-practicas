package com.bootcamp.blog.excepciones;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
