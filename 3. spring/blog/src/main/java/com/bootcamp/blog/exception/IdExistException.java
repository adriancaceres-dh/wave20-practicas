package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.MensajeEntradaBlogResponseDto;
import lombok.Getter;

@Getter
public class IdExistException extends RuntimeException{

    private MensajeEntradaBlogResponseDto mensajeDto;

    public IdExistException(MensajeEntradaBlogResponseDto mensajeDto) {
        this.mensajeDto = mensajeDto;
    }

}
