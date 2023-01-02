package com.bootcamp.BlogYoutuber.exceptions;

public class InsertBlogException extends RuntimeException{

    public InsertBlogException(String mensaje){
        super(mensaje);
    }
}
