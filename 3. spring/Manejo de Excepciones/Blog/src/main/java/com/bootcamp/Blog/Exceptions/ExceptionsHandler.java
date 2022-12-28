package com.bootcamp.Blog.Exceptions;

import com.bootcamp.Blog.Controllers.BlogController;
import com.bootcamp.Blog.DTO.MensajeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionsHandler{

    @ExceptionHandler(BlogNullException.class)
    public ResponseEntity<MensajeDto> entradaBlogNull(Exception e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
