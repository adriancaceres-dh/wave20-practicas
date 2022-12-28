package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.MensajeExceptionDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class NotFoundException extends RuntimeException{

    MensajeExceptionDTO mensajeExceptionDTO;
    public NotFoundException(String message, MensajeExceptionDTO mensaje){
        super(message);
        this.mensajeExceptionDTO = mensaje;
    }
}
