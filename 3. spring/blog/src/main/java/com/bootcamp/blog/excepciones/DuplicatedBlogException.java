package com.bootcamp.blog.excepciones;

public class DuplicatedBlogException extends RuntimeException {
    public DuplicatedBlogException(String mensaje) {
        super(mensaje);
    }
}
