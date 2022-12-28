package com.bootcamp.Blog.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "El objeto ingresado no puede se nulo.")
public class BlogNullException extends RuntimeException {

    public BlogNullException(String mensaje) {
        super(mensaje);
    }
}
