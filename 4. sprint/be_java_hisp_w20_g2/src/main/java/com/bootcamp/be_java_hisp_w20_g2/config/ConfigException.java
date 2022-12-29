package com.bootcamp.be_java_hisp_w20_g2.config;

import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConfigException
{
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity exception(BadRequestException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());

    }

}
