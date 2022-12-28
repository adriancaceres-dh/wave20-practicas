package com.bootcamp.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Entrada ya existe")
public class BlogExistExceptions extends RuntimeException{

    public BlogExistExceptions(String message) {
        super(message);
    }
}
