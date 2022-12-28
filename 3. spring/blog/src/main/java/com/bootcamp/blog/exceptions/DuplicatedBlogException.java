package com.bootcamp.blog.exceptions;


public class DuplicatedBlogException extends RuntimeException {
    public DuplicatedBlogException(String mensaje) {
        super(mensaje);
    }
}