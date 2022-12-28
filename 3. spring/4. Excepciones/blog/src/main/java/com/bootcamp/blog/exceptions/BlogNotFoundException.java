package com.bootcamp.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entrada no encontrada")
public class BlogNotFoundException extends  RuntimeException{

    public BlogNotFoundException(String message) {
        super(message);
    }
}
