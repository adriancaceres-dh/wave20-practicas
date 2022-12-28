package com.bootcamp.Blog.Exceptions;

import com.bootcamp.Blog.Controllers.BlogController;
import com.bootcamp.Blog.DTO.MensajeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class BlogException extends RuntimeException {

    public BlogException(String mensaje) {
        super(mensaje);
    }
}
