package com.bootcamp.BlogYoutuber.exceptions;

public class NotFoundBlogException extends RuntimeException{

    public NotFoundBlogException(String mensaje) {
        super(mensaje);
    }
}
